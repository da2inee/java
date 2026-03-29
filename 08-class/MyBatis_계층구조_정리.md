# MyBatis(SQL) 계층 구조 정리

## 전제 (JPA vs MyBatis 핵심 차이)
- **JPA**: 엔티티 중심(영속성 컨텍스트가 PK로 엔티티를 추적)이라 `@Id` 같은 식별자 설정이 중요하다.
- **MyBatis**: SQL 중심(내가 작성한 SQL이 기준)이라 `@Id`처럼 “프레임워크에 PK를 선언”하는 개념이 필수는 아니다.

## 전체 흐름 (추천 기본형)
가장 흔한 기본 구조는 아래처럼 본다.

```
Client
  ↔ (Request/Response DTO)
Controller
  ↔ (Request/Response DTO)
Service
  ↔ (Param DTO / Result DTO)  // 또는 도메인(Entity)로 변환
Mapper(=DAO/Repository 역할)
  ↔ (Param DTO / Result DTO)  // mapper.xml과 매핑
DB
```

## “Repository를 안 쓰는 거야?”에 대한 결론
- MyBatis에서는 보통 **`Mapper 인터페이스(mapper.java)`가 DAO/Repository 역할**을 한다.
- 필요하면 `Repository/Dao` 클래스를 **Mapper 위에 한 겹 더** 두기도 한다.
  - 예: 여러 Mapper 조합, 트랜잭션 단위 작업 묶기, 도메인 변환/검증 등

## mapper.xml ↔ mapper.java ↔ 객체(DTO/Entity) 연결은 뭐라고 불러?
상황별로 부르는 이름이 다르다.

### 1) SQL 결과를 담는 객체
- `resultType` / `resultMap`으로 **조회 결과를 받는 자바 클래스**
- 보통 **DTO(또는 VO)** 라고 부른다.
  - 조인/집계처럼 “테이블 1개 = 객체 1개”로 딱 안 떨어질수록 DTO로 분리하는 편이 깔끔하다.

### 2) SQL 파라미터를 담는 객체
- `parameterType` 또는 메서드 파라미터로 넘기는 **조건/요청 값 묶음 객체**
- 보통 **Request DTO / Param DTO / Search DTO** 라고 부른다.

### 3) mapper.xml의 `<resultMap>`
- 이건 자바 객체가 아니라 **매핑 정의(설정)** 자체다.
- DTO라고 부르기보단 “resultMap(매핑)”이라고 부르는 편이 정확하다.

## 케이스별로 흐름을 어떻게 잡는 게 좋나?

### A) 조회(리스트/조인/화면용) — DTO 중심이 보통 편함
```
Client ↔ Response DTO ↔ Controller ↔ Service ↔ Mapper ↔ (Result DTO) ↔ DB
```
- 조회 결과는 화면/요구사항에 맞춰 필드가 자주 바뀌어서 **DTO로 받는 게 변경에 강함**

### B) 등록/수정/삭제 — Request/Param 객체로 내려보내기
```
Client → Request DTO → Controller → Service → Mapper(DAO) → DB
```
- Service에서 필요한 값만 추려 **Param DTO**로 Mapper에 전달해도 된다.

### C) 도메인(Entity)도 쓰고 싶을 때 — Service에서만 도메인 유지
```
Client ↔ DTO ↔ Controller ↔ Service(도메인/Entity) ↔ Mapper ↔ DTO ↔ DB
```
- Mapper는 SQL 결과 모양에 맞춘 DTO로 받고,
- Service에서 DTO → Entity 변환/검증을 하며 도메인 규칙을 관리하는 방식도 흔하다.

## 실무에서 중요한 포인트
- **Mapper 인터페이스 = DB 접근 계층**(Repository/DAO 역할)로 보면 이해가 빠르다.
- MyBatis는 “PK를 선언”하기보다, **SQL에서 PK 조건을 직접 쓰고** 매핑을 맞춘다.
- 조회는 DTO, 변경은 Request/Param DTO로 나누면 계층이 깔끔해진다.

## 한 줄 정리
MyBatis는 **SQL 중심**이라서 보통 `Mapper 인터페이스(DAO/Repository 역할)` + `DTO(파라미터/결과)`로 계층을 구성하고, 필요하면 Service에서만 도메인(Entity)을 유지한다.

