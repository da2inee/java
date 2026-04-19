# 스프링 면접 QnA

## 코어
1. IoC와 DI 차이?
- 답:

2. 생성자 주입을 권장하는 이유?
- 답:

3. Bean 생명주기 설명?
- 답:

4. AOP를 왜 쓰나?
- 답:

5. @Transactional이 동작하는 방식?
- 답:
  - 스프링은 `@Transactional`이 붙은 메서드에 대해 **프록시(AOP)** 를 만들어 트랜잭션을 적용한다.
  - 메서드 호출 전 **트랜잭션 시작**, 정상 종료 시 **커밋**, 예외 발생 시 **롤백**한다.
  - 기본 롤백 규칙은 **RuntimeException/Error는 롤백**, **Checked Exception은 커밋**이며, 필요하면 `rollbackFor`로 조정한다.
  - 프록시 기반이라 **같은 클래스 내부의 자기 호출(self-invocation)** 은 트랜잭션이 적용되지 않을 수 있다는 점을 주의한다.

## MVC / REST
6. @PathVariable, @RequestParam, @RequestBody 차이?
- 답:

7. REST 상태코드 기준?
- 답:

8. 공통 예외 처리는 어떻게?
- 답:

## JPA / DB
9. N+1 문제와 해결법?
- 답:

10. 낙관적 락 vs 비관적 락?
- 답:

## Batch / WebFlux
11. Batch의 Chunk 처리란?
- 답:

12. MVC와 WebFlux 차이?
- 답:

## 내 경험 연결
13. 트랜잭션 문제를 해결한 경험?
- 답:

14. 성능 개선 경험?
- 답:
