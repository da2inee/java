# 스프링 Batch 학습노트

## 목표
- Spring Batch의 기본 구성(Job/Step/Reader/Processor/Writer)을 설명할 수 있다.
- 대용량 처리에서 실패 복구/재시작 전략을 설명할 수 있다.

## 1. Spring Batch가 필요한 이유
- 대량 데이터 정기 처리
- 실패 복구 및 재시작
- 이력 관리 및 모니터링

## 2. 핵심 구성요소
- Job
- Step
- ItemReader
- ItemProcessor
- ItemWriter
- JobRepository

## 3. 처리 방식
- Chunk 기반 처리
- Tasklet 기반 처리
- commit-interval 설정 의미

## 4. 운영 포인트
- Skip / Retry 정책
- 멱등성(idempotency)
- JobParameters 설계
- 스케줄러 연동 (예: Cron)

## 5. 실무 체크
- 배치 중복 실행 방지
- 실패 알림/재처리 전략
- 처리 성능(Chunk 크기, I/O 병목) 점검

## 6. 예시 코드 (Spring Boot 기준)

> Chunk 예시는 **DB 없이** `ListItemReader`로 동작 확인만 할 때 적합합니다. 재시작·이력(JobRepository JDBC)까지 쓰려면 배치 메타 테이블 스키마와 `DataSource` 설정이 필요합니다.

### 6.1 의존성 (Gradle)

```kotlin
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-batch")
    // JDBC JobRepository 사용 시
    runtimeOnly("com.h2database:h2") // 또는 사용 중인 DB 드라이버
}
```

### 6.2 Chunk 처리: Reader → Processor → Writer

대량 처리의 기본 흐름이다. **`chunk(size)`개씩 모아 트랜잭션 커밋**한다고 이해하면 된다.

```java
@Configuration
@EnableBatchProcessing
public class SampleChunkConfig {

    @Bean
    public Job sampleJob(JobRepository jobRepository, Step uppercaseStep) {
        return new JobBuilder("sampleJob", jobRepository)
                .start(uppercaseStep)
                .build();
    }

    @Bean
    public Step uppercaseStep(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager) {

        return new StepBuilder("uppercaseStep", jobRepository)
                .<String, String>chunk(10, transactionManager)
                .reader(stringReader())
                .processor(toUpperProcessor())
                .writer(logWriter())
                .build();
    }

    /** 실제로는 FlatFile/CursorJdbc 등으로 교체 */
    @Bean
    public ItemReader<String> stringReader() {
        return new ListItemReader<>(List.of("apple", "banana", "cherry"));
    }

    @Bean
    public ItemProcessor<String, String> toUpperProcessor() {
        return String::toUpperCase; // null을 Writer로 안 넘기려면 null 리턴 시 스킵 정책 등 고려
    }

    /** 실제로는 JdbcBatchItemWriter, JpaItemWriter 등 */
    @Bean
    public ItemWriter<String> logWriter() {
        return chunks -> chunks.forEach(item -> System.out.println("WRITE: " + item));
    }
}
```

### 6.3 Job 실행 (테스트 또는 앱 기동 시 1번 실행)

동일 논리 Job은 **실행 구분용 `JobParameters`**가 달라야 다시 실행할 수 있다 (`run.id` 같은 값을 매번 새로 두는 패턴이 흔함).

```java
@Component
public class SampleJobRunner implements ApplicationRunner {

    private final JobLauncher jobLauncher;
    private final Job sampleJob;

    public SampleJobRunner(JobLauncher jobLauncher, Job sampleJob) {
        this.jobLauncher = jobLauncher;
        this.sampleJob = sampleJob;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        JobParameters parameters = new JobParametersBuilder()
                .addLong("run.id", System.currentTimeMillis())
                .toJobParameters();

        jobLauncher.run(sampleJob, parameters);
    }
}
```

`Job` 빈이 여러 개면 `@Qualifier("sampleJob")`로 주입 이름을 지정한다.

### 6.4 Tasklet 예시 (“한 줄짜리 작업”에 적합)

Chunk가 아니라 **한 번(또는 루프로 RepeatStatus까지)** 수행하고 끝낼 때 쓴다.

```java
@Bean
public Step pingStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
    return new StepBuilder("pingStep", jobRepository)
            .tasklet((contribution, chunkContext) -> {
                System.out.println("TASKLET 실행");
                return RepeatStatus.FINISHED;
            }, transactionManager)
            .build();
}
```

### 6.5 Skip / Retry 설정 예시 (개념)

일부 레코드만 깨질 때 **전체 Step 실패 대신 넘길 최대 건수** 등을 줄 수 있다.

```java
return new StepBuilder("riskyStep", jobRepository)
        .<String, String>chunk(50, transactionManager)
        .reader(reader)
        .processor(processor)
        .writer(writer)
        .faultTolerant()
        .skip(IllegalArgumentException.class)
        .skipLimit(10)
        .retry(SocketTimeoutException.class)
        .retryLimit(3)
        .build();
```

## 체크리스트
- [ ] Chunk와 Tasklet 차이 설명 가능
- [ ] Skip/Retry를 언제 쓰는지 설명 가능
- [ ] 재시작 가능한 배치 설계 가능
