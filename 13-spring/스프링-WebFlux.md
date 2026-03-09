# 스프링 WebFlux 학습노트

## 목표
- WebFlux의 논블로킹 모델을 이해하고 MVC와 차이를 설명할 수 있다.
- Mono/Flux 사용법과 적용 기준을 말할 수 있다.

## 1. WebFlux 개요
- 논블로킹/비동기 웹 스택
- 이벤트 루프 기반 처리(Netty 등)
- 적은 스레드로 높은 동시성 처리

## 2. 핵심 타입
- Mono<T> : 0~1개
- Flux<T> : 0~N개

## 3. MVC vs WebFlux
- MVC: 블로킹, 서블릿 기반, 직관적
- WebFlux: 논블로킹, 리액티브 스트림 기반, 고동시성 유리
- 어떤 상황에서 무엇을 선택할지 기준 정리

## 4. 주의사항
- 블로킹 코드 섞으면 성능 이점 감소
- 리액티브 체인 디버깅 난이도
- 팀 숙련도 중요

## 5. 실습 포인트
- WebClient로 외부 API 비동기 호출
- Mono/Flux 변환(map, flatMap)
- 에러 처리(onErrorResume 등)

## 체크리스트
- [ ] Mono/Flux 차이 설명 가능
- [ ] WebFlux를 써야 하는 상황 설명 가능
- [ ] MVC와 혼합 시 주의점 설명 가능
