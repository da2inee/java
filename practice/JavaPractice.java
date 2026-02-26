/**
 * 자바 실습 - 메뉴로 단계별 예시 실행
 *
 * 실행: javac JavaPractice.java && java JavaPractice
 * 1~10 번호 입력하면 해당 단계 예시가 실행됩니다. 0 입력 시 종료.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class JavaPractice {

    /** 프로그램 진입점. 메뉴를 반복 출력하고, 입력한 번호에 따라 해당 예시를 실행한다. */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // 키보드 입력 받기
        int choice;  // 사용자가 입력한 메뉴 번호

        do {
            // 메뉴 출력
            System.out.println("\n=== 자바 실습 메뉴 ===");
            System.out.println("1. 변수·타입    2. 연산자    3. 조건문    4. 반복문");
            System.out.println("5. 메서드      6. 배열      7. 클래스·객체  8. String");
            System.out.println("9. 예외 처리   10. 컬렉션");
            System.out.println("0. 종료");
            System.out.print("번호 입력: ");
            choice = sc.nextInt();  // 정수 하나 입력

            // 입력한 번호에 따라 해당 단계 예시 메서드 호출
            switch (choice) {
                case 1: demoVariables(); break;
                case 2: demoOperators(); break;
                case 3: demoCondition(); break;
                case 4: demoLoop(); break;
                case 5: demoMethod(); break;
                case 6: demoArray(); break;
                case 7: demoClass(); break;
                case 8: demoString(); break;
                case 9: demoException(); break;
                case 10: demoCollection(); break;
                case 0: System.out.println("종료합니다."); break;
                default: System.out.println("1~10 또는 0을 입력하세요.");
            }
        } while (choice != 0);  // 0이 아니면 메뉴 다시 표시

        sc.close();  // Scanner 사용 끝나면 닫기
    }

    /** 1. 변수·타입: int, double, String, boolean 선언 후 출력 */
    static void demoVariables() {
        System.out.println("\n--- 1. 변수·타입 ---");
        int age = 20;           // 정수
        double height = 175.5; // 실수
        String name = "홍길동"; // 문자열 (참조 타입)
        boolean isStudent = true; // 참/거짓
        System.out.println("이름: " + name + ", 나이: " + age + ", 키: " + height + ", 학생? " + isStudent);
    }

    /** 2. 연산자: 산술(+,/,%), 비교(>,==), 논리(&&) 예시 */
    static void demoOperators() {
        System.out.println("\n--- 2. 연산자 ---");
        int a = 10, b = 3;
        // 산술: 정수끼리 / 는 몫, % 는 나머지
        System.out.println("a + b = " + (a + b) + ", a / b = " + (a / b) + ", a % b = " + (a % b));
        // 비교: 결과는 boolean
        System.out.println("a > b ? " + (a > b) + ", a == 10 ? " + (a == 10));
        // 논리: && 그리고
        System.out.println("a가 0~20 사이? " + (a > 0 && a < 20));
    }

    /** 3. 조건문: 점수에 따라 등급(A/B/C/F) 출력 */
    static void demoCondition() {
        System.out.println("\n--- 3. 조건문 ---");
        int score = 85;
        if (score >= 90) System.out.println("등급: A");
        else if (score >= 80) System.out.println("등급: B");
        else if (score >= 70) System.out.println("등급: C");
        else System.out.println("등급: F");
    }

    /** 4. 반복문: for로 1~5 출력, while로 1~5 합 구하기 */
    static void demoLoop() {
        System.out.println("\n--- 4. 반복문 ---");
        System.out.print("for 1~5: ");
        for (int i = 1; i <= 5; i++) System.out.print(i + " ");  // i 1부터 5까지
        System.out.println();
        int sum = 0, j = 1;
        while (j <= 5) { sum += j; j++; }  // j가 5 이하인 동안 sum에 j 더하고 j 증가
        System.out.println("1~5 합: " + sum);
    }

    /** 5. 메서드: void 메서드 호출, return 값 있는 메서드 호출 */
    static void demoMethod() {
        System.out.println("\n--- 5. 메서드 ---");
        sayHi();  // 반환값 없음
        System.out.println("add(3, 5) = " + add(3, 5));  // 반환값 사용
    }
    /** 반환값 없는 메서드 (void) */
    static void sayHi() { System.out.println("안녕!"); }
    /** 두 정수를 받아 합을 반환 */
    static int add(int a, int b) { return a + b; }

    /** 6. 배열: 선언, length, for로 순회 */
    static void demoArray() {
        System.out.println("\n--- 6. 배열 ---");
        int[] arr = { 10, 20, 30 };  // 배열 리터럴로 초기화
        System.out.println("arr[0] = " + arr[0] + ", length = " + arr.length);  // 인덱스 0, 길이
        for (int i = 0; i < arr.length; i++) System.out.println("  arr[" + i + "] = " + arr[i]);
    }

    /** 7. 클래스·객체: Person 객체 생성 후 메서드 호출 */
    static void demoClass() {
        System.out.println("\n--- 7. 클래스·객체 ---");
        Person p = new Person("김자바", 25);  // 생성자로 객체 생성
        p.introduce();  // 인스턴스 메서드 호출
    }

    /** 8. String: ==(참조 비교) vs equals(내용 비교) */
    static void demoString() {
        System.out.println("\n--- 8. String ---");
        String a = "hello", b = "hello", c = new String("hello");
        // 리터럴끼리는 같은 객체일 수 있음, new는 항상 새 객체
        System.out.println("a == b ? " + (a == b) + ", a.equals(b) ? " + a.equals(b));
        System.out.println("a == c ? " + (a == c) + ", a.equals(c) ? " + a.equals(c));
    }

    /** 9. 예외 처리: try-catch로 NumberFormatException 잡기 */
    static void demoException() {
        System.out.println("\n--- 9. 예외 처리 ---");
        try {
            int n = Integer.parseInt("123");  // 정상: 숫자로 파싱됨
            System.out.println("파싱 결과: " + n);
        } catch (NumberFormatException e) {
            System.out.println("숫자 아님: " + e.getMessage());
        }
        try {
            int x = Integer.parseInt("abc");  // "abc"는 숫자 아님 → 예외 발생
            System.out.println(x);
        } catch (NumberFormatException e) {
            System.out.println("예외 잡음: " + e.getMessage());
        }
    }

    /** 10. 컬렉션: List(순서O 중복O), Set(중복X), Map(키-값) */
    static void demoCollection() {
        System.out.println("\n--- 10. 컬렉션 ---");
        List<String> list = new ArrayList<>();
        list.add("가"); list.add("나"); list.add("다");
        System.out.println("List: " + list + ", get(1) = " + list.get(1));

        Set<String> set = new HashSet<>();
        set.add("a"); set.add("b"); set.add("a");  // "a" 중복 → 하나만 저장
        System.out.println("Set: " + set);

        Map<String, Integer> map = new HashMap<>();
        map.put("김", 90); map.put("이", 85);  // 키-값 쌍
        System.out.println("Map: " + map + ", get(\"김\") = " + map.get("김"));
    }

    /** 7번용: 이름·나이를 갖는 간단한 클래스 (생성자 + introduce 메서드) */
    static class Person {
        String name;  // 필드
        int age;
        /** 생성자: 객체 생성 시 name, age 초기화 */
        Person(String name, int age) { this.name = name; this.age = age; }
        /** 자기소개 출력 */
        void introduce() { System.out.println("저는 " + name + ", " + age + "살입니다."); }
    }
}
