package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 앱 시작점.
 * - @SpringBootApplication: 컴포넌트 스캔 + 자동 설정을 포함한 앱 진입점 표시
 * 실행: mvn spring-boot:run  또는 IDE에서 이 클래스 Run
 */
@SpringBootApplication  // 이 클래스가 Spring Boot 앱의 시작점임을 표시
public class DemoApplication {

    /** JVM이 호출하는 main. Spring Boot 서버를 띄운다. */
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
