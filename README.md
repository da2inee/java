# 자바 공부 순서

이 폴더에서 아래 순서대로 연습하면 됩니다.

**→ 전체 예시 한 번에 보기**: [`전체-자바-예시.md`](전체-자바-예시.md) (모든 단계 예시 코드 정리)

| 순서 | 폴더/파일 | 내용 |
|------|-----------|------|
| 0 | `00-compilation/` | **컴파일 과정** (.java → .class → JVM) |
| 0-1 | `00-compilation/01-jvm-메모리.md` | **JVM 구조·메모리** (스택/힙, 면접용) |
| 0-2 | `00-compilation/02-GC-가비지컬렉션.md` | **GC** (가비지 컬렉션, Minor/Major, 면접용) |
| 0-3 | `00-compilation/03-메모리-왜-나누나.md` | **메서드 영역/힙/스택을 왜 나누나** (예시로 설명) |
| 1 | `01-hello-world/` | 첫 프로그램, 실행 방법 |
| 2 | `02-variables/` | 변수, 데이터 타입 |
| 3 | `03-operators/` | 연산자 (산술, 비교, 논리) |
| 4 | `04-condition/` | if, else, switch |
| 5 | `05-loop/` | for, while |
| 6 | `06-methods/` | 메서드 정의와 호출 |
| 7 | `07-arrays/` | 배열 |
| 8 | `08-class/` | 클래스와 객체, **`생성자.md`**, **`오버로딩-오버라이딩.md`** |
| 9 | `09-annotations/` | **어노테이션** (자바 기본, Spring 요청/구조) |
| 10 | `10-string/` | **String** (불변, equals vs ==, 면접용) |
| 11 | `11-exception/` | **예외 처리** (try-catch-finally, Checked/Unchecked, throws, 예제) |
| 12 | `12-collection/` | **컬렉션** (List, Set, Map, ArrayList, HashMap 예제) |
| 13 | `13-spring/` | **스프링** (IoC/DI, Bean, MVC, 어노테이션 정리) |
| 14 | `spring-example/` | **Spring Boot 예제** (REST API, GET/POST, RequestParam/RequestBody) |
| 15 | 이후 | 상속, 인터페이스 등 |

**실행 방법 (터미널)**  
- 일반 자바: 해당 폴더에서 `javac 파일명.java` → `java 클래스이름`
- Spring Boot 예제: `cd spring-example` → `mvn spring-boot:run` (Maven 설치 필요) 또는 IDE에서 `DemoApplication` 실행

---

1번부터 차례대로 공부하기
