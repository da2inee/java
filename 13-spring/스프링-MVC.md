# 스프링 MVC 학습노트

## 목표
- 요청이 들어와서 응답이 나가기까지 흐름을 설명할 수 있다.
- REST API를 설계하고 예외/검증까지 적용할 수 있다.

## 1. 요청 처리 흐름
1. DispatcherServlet
2. HandlerMapping
3. Controller
4. Service
5. Response(JSON/View)

## 2. 핵심 어노테이션
- @RestController / @Controller
- @RequestMapping, @GetMapping, @PostMapping, @PutMapping, @PatchMapping, @DeleteMapping
- @PathVariable, @RequestParam, @RequestBody
- @Valid, BindingResult

## 3. REST 설계 원칙
- 리소스 중심 URL
- HTTP 메서드 의미 일치
- 상태코드 표준화 (200, 201, 204, 400, 404, 409, 500)
- 에러 응답 포맷 통일

## 4. 예외 처리
- @ExceptionHandler
- @ControllerAdvice / @RestControllerAdvice
- 비즈니스 예외 vs 시스템 예외

## 5. 검증
- Bean Validation
- DTO 검증 규칙 정리
- 검증 실패 응답 구조

## 체크리스트
- [ ] @PathVariable / @RequestParam / @RequestBody 차이 설명 가능
- [ ] 상태코드 선택 기준 설명 가능
- [ ] 공통 예외 처리 구조 만들 수 있음
