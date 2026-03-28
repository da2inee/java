# REST API 핵심 정리

## REST API란?
- REST(Representational State Transfer) 스타일을 따르는 API 설계 방식이다.
- 서버의 데이터(리소스)를 URL로 표현하고, HTTP 메서드로 동작을 구분한다.
- 보통 JSON 형식으로 데이터를 주고받는다.

## 핵심 원칙
## 1) 리소스 중심 URL
- 동작(verb)보다 대상(resource, noun)을 URL에 표현한다.
- 좋은 예: `/users`, `/orders/1`, `/products/10/reviews`
- 피할 예: `/getUsers`, `/createOrder`, `/deleteProduct`

## 2) HTTP 메서드 의미 일치
- `GET`: 조회
- `POST`: 생성
- `PUT`: 전체 수정(대체)
- `PATCH`: 부분 수정
- `DELETE`: 삭제

## 3) 무상태(Stateless)
- 각 요청은 독립적이어야 한다.
- 서버는 이전 요청의 클라이언트 상태를 세션처럼 의존하지 않는 방향이 좋다.

## 4) 일관된 응답 구조
- 성공/실패 응답 포맷을 팀 기준으로 통일한다.
- 예시(성공): `{"data": {...}, "message": "ok"}`
- 예시(실패): `{"errorCode": "USER_NOT_FOUND", "message": "..."}`

## 5) 표준 상태코드 사용
- `200 OK`: 조회/수정 성공
- `201 Created`: 생성 성공
- `204 No Content`: 삭제 성공(응답 본문 없음)
- `400 Bad Request`: 잘못된 요청(검증 실패 등)
- `401 Unauthorized`: 인증 필요
- `403 Forbidden`: 권한 없음
- `404 Not Found`: 리소스 없음
- `409 Conflict`: 중복/충돌
- `500 Internal Server Error`: 서버 내부 오류

## URL 설계 가이드
- 복수형 명사 사용: `/users`
- 계층 관계는 슬래시로 표현: `/users/{userId}/orders`
- 일관된 네이밍 유지(kebab-case 또는 snake_case 등 팀 규칙 통일)
- 버전 전략 고려: `/api/v1/users`
- 쿼리 파라미터는 필터/정렬/페이지네이션에 사용
  - 예: `/users?page=0&size=20&sort=createdAt,desc`

## 스프링부트 기본 매핑 예시
- `GET /api/users` -> 목록 조회
- `GET /api/users/{id}` -> 단건 조회
- `POST /api/users` -> 사용자 생성
- `PATCH /api/users/{id}` -> 사용자 부분 수정
- `DELETE /api/users/{id}` -> 사용자 삭제

## 요청/응답 DTO 분리 권장
- 엔티티를 API로 직접 노출하지 않는다.
- Request DTO, Response DTO를 분리해 API 계약을 안정적으로 유지한다.

## 예외 처리 권장
- `@RestControllerAdvice`로 공통 예외 처리
- 비즈니스 예외와 시스템 예외를 구분
- 예외별 상태코드/에러코드/메시지 규칙 통일

## 페이징/정렬/검색
- 목록 API는 초기에 페이징을 고려한다.
- 응답에 메타 정보(현재 페이지, 총 개수 등)를 포함하면 프론트 연동이 편하다.

## 체크리스트
- [ ] URL이 리소스 중심으로 설계되어 있다.
- [ ] HTTP 메서드와 동작 의미가 맞다.
- [ ] 상태코드를 상황에 맞게 반환한다.
- [ ] 성공/실패 응답 포맷이 일관적이다.
- [ ] 공통 예외 처리(`@RestControllerAdvice`)가 적용되어 있다.
- [ ] DTO 기반으로 API 계약을 관리한다.
