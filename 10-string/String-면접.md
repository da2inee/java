# String (면접 대비)

면접에서 **"String 불변성이 뭔가요?", "equals와 == 차이가 뭔가요?"** 자주 나옵니다.

---

## 1. String 불변성 (Immutability)

- **불변** = 한 번 만들어진 문자열 객체는 **내용을 바꿀 수 없음**.
- `str = str + "추가"` 처럼 쓰면 **새 String 객체**가 만들어지고, 변수만 그걸 가리킴. 기존 객체는 안 바뀜.

**왜 불변으로 설계했나?**

- 문자열 풀(String Pool) 재사용, 스레드 안전, 해시코드 고정 등으로 **캐싱·동기화·키 사용**이 쉬움.

**면접 답**: "String은 한 번 생성되면 값이 안 바뀌고, 연산하면 새 객체가 만들어집니다. 그래서 불변이라고 합니다."

---

## 2. equals vs ==

| 구분 | == | equals |
|------|----|--------|
| **의미** | **참조(주소)** 가 같은가 | **내용**이 같은가 |
| **String** | 같은 객체를 가리키면 true | 문자가 같으면 true |

```java
String a = "hello";
String b = "hello";
String c = new String("hello");

a == b;      // true  (리터럴 풀에서 같은 객체)
a.equals(b); // true  (내용 같음)
a == c;      // false (서로 다른 객체)
a.equals(c); // true  (내용 같음)
```

**면접 답**: "==는 참조 비교, equals는 내용 비교입니다. String은 equals로 비교해야 합니다."

---

## 3. 리터럴 vs new String()

- **리터럴** `"hello"` → **문자열 풀**에 올라가고, 같은 리터럴이면 **같은 객체 재사용**.
- **new String("hello")** → **힙에 새 객체** 생성. 풀과 무관.

그래서 `"a" == "a"` 는 true일 수 있지만, `new String("a") == "a"` 는 false.

---

## 4. StringBuilder / StringBuffer

- **연산 많을 때** `str = str + "x"` 반복하면 매번 새 String 만들어서 비효율.
- **StringBuilder** – 가변, 한 객체에 이어 붙임. 단일 스레드용.
- **StringBuffer** – 가변, **동기화** 지원. 멀티스레드에서 안전.

**면접 답**: "문자열을 자주 이어 붙일 때는 StringBuilder를 쓰면 됩니다. 스레드 안전이 필요하면 StringBuffer를 씁니다."

---

## 정리 (면접용 한 줄씩)

1. **String 불변** – 생성 후 내용 변경 불가, 연산 시 새 객체 생성.
2. **equals vs ==** – equals는 내용 비교, ==는 참조 비교. String은 equals 사용.
3. **리터럴 vs new** – 리터럴은 풀에서 재사용, new는 매번 새 객체.
4. **StringBuilder** – 이어 붙일 때 가변으로 효율적. 멀티스레드면 StringBuffer.
