# Access Token / Refresh Token / 저장 전략(웹)

## 왜 토큰을 2개로 나누나?
토큰이 탈취될 수 있다는 전제를 두면,
- API 호출용 토큰(access)은 **짧게**
- 재발급용 토큰(refresh)은 **길게** 가져가고 관리(폐기/회전)를 강화하는 게 유리하다.

## Access Token
- 용도: API 호출(Authorization 헤더로 보내는 경우가 많음)
- 특성: 만료를 짧게 가져감(예: 5~30분)

## Refresh Token
- 용도: access가 만료되면 **새 access 발급**을 위해 사용
- 특성: 만료가 길다(예: 1~4주)
- 운영: 보통 서버에서 refresh를 **저장/폐기 관리**한다.
  - 예: refresh “1회용 회전(rotating refresh)” 방식

## 웹 저장 전략 (중요)
“어디에 저장하느냐”는 보안/편의성 트레이드오프다.

### 1) localStorage / sessionStorage
- 장점: 구현이 쉬움
- 단점: JS로 접근 가능 → **XSS에 취약**

### 2) 쿠키(HttpOnly)
- 장점: `HttpOnly`면 JS 접근 불가 → XSS에 비교적 강함
- 단점: 쿠키는 자동 전송되므로 설정을 잘못하면 **CSRF 위험**
  - `SameSite` 설정이 중요

## 많이 쓰는 조합(예시)
- **Refresh Token**: `HttpOnly + Secure + SameSite` 쿠키
- **Access Token**: 메모리(상태) 또는 필요 시 짧게 보관

프로젝트 상황에 따라 정답은 달라질 수 있지만,
웹에서는 “refresh를 쿠키로 보호”하는 접근이 자주 쓰인다.

## 서버 검증 포인트
- access 검증: 서명/만료/클레임 확인
- refresh 검증: 서명/만료 + **서버 저장소에서 유효성 확인(폐기 여부, 회전 여부 등)**

## 한 줄 정리
Access는 **짧게**, Refresh는 **길게** + **서버에서 통제**, 웹에서는 Refresh를 `HttpOnly` 쿠키로 두는 설계가 흔하다.

