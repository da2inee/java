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

## 체크리스트
- [ ] Chunk와 Tasklet 차이 설명 가능
- [ ] Skip/Retry를 언제 쓰는지 설명 가능
- [ ] 재시작 가능한 배치 설계 가능
