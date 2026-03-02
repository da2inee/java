# Spring Boot 예제 프로젝트

스프링 개념(`13-spring/스프링.md`)과 같이 보면서 **REST API** 예시를 실행해 보는 프로젝트예요.

---

## 필요한 것

- **JDK 11** 이상
- **Maven** (설치 후 `mvn spring-boot:run` 사용. 또는 IDE에서 실행)

---

## 실행 방법

### 1) Maven으로 실행

```bash
cd spring-example
mvn spring-boot:run
```

### 2) IDE에서 실행

- `com.example.demo.DemoApplication` 클래스에서 **Run** (main 메소드 실행)

---

## 실행 후 확인

서버가 뜨면 **브라우저** 또는 **curl** 로 아래 주소 호출해 보세요.

| 요청 | URL | 결과 예시 |
|------|-----|-----------|
| GET | http://localhost:8080/hello | `Hello, Spring!` |
| GET | http://localhost:8080/hello/김철수 | `Hello, 김철수` |
| GET | http://localhost:8080/greet?name=이영희 | `Hi, 이영희` |
| GET | http://localhost:8080/greet | `Hi, Guest` |
| POST | http://localhost:8080/users | Body: `{"name":"김","age":25}` → JSON 그대로 반환 |

**curl 예시**

```bash
curl http://localhost:8080/hello
curl "http://localhost:8080/greet?name=테스트"
curl -X POST http://localhost:8080/users -H "Content-Type: application/json" -d '{"name":"김","age":25}'
```

---

## 프로젝트 구조

```
spring-example/
├── pom.xml
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java      # @SpringBootApplication, main
│   ├── controller/
│   │   └── HelloController.java  # @RestController, @GetMapping, @PostMapping
│   └── dto/
│       └── UserDto.java          # @RequestBody 바인딩용
└── src/main/resources/
    └── application.properties    # server.port=8080
```

---

## 스프링 개념 복습

- **13-spring/스프링.md** 에 IoC/DI, Bean, 어노테이션, MVC 흐름 정리돼 있어요.
- 컨트롤러 코드 보면서 `@GetMapping`, `@RequestParam`, `@PathVariable`, `@RequestBody` 가 어떻게 쓰이는지 확인하면 돼요.
