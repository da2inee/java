/**
 * 자바 실습 - 직접 채워 보기
 *
 * 아래 메서드들에 주석대로 코드를 넣어 보세요.
 * 실행: javac MyPractice.java && java MyPractice
 */
import java.util.ArrayList;
import java.util.List;

public class MyPractice {

    /** 진입점: 각 단계 연습 메서드를 순서대로 호출 */
    public static void main(String[] args) {
        System.out.println("=== MyPractice 실행 ===\n");

        practiceVariables();    // 1. 변수
        practiceOperators();    // 2. 연산자 (짝수/홀수)
        practiceCondition();    // 3. 조건문 (등급)
        practiceLoop();        // 4. 반복문 (합)
        practiceMethod();      // 5. 메서드 (곱하기)
        practiceArray();       // 6. 배열 (최댓값)
        practiceString();     // 8. String (equals)
        practiceException();  // 9. 예외 (try-catch)
        practiceCollection(); // 10. 컬렉션 (List for-each)
    }

    /** 1. 변수: 나이(정수), 이름(문자열) 변수를 만들고 출력하세요. */
    static void practiceVariables() {
        int age = 20;           // 정수 타입 변수
        String name = "내이름";  // 문자열 변수
        System.out.println("1. 변수: 이름=" + name + ", 나이=" + age);
    }

    /** 2. 연산자: 정수 하나를 정해서, 짝수면 "짝수", 홀수면 "홀수" 출력. (a % 2 == 0 이면 짝수) */
    static void practiceOperators() {
        int a = 7;
        if (a % 2 == 0) {  // 나머지가 0이면 짝수
            System.out.println("2. 연산자: 짝수");
        } else {
            System.out.println("2. 연산자: 홀수");
        }
    }

    /** 3. 조건문: 점수 변수를 정하고, 90 이상 A, 80 이상 B, 70 이상 C, 나머지 F 출력 */
    static void practiceCondition() {
        int score = 85;
        if (score >= 90) System.out.println("3. 조건문: A");
        else if (score >= 80) System.out.println("3. 조건문: B");
        else if (score >= 70) System.out.println("3. 조건문: C");
        else System.out.println("3. 조건문: F");
    }

    /** 4. 반복문: 1부터 10까지의 합을 구해서 출력 (for 사용) */
    static void practiceLoop() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) sum += i;  // i를 1~10까지 sum에 더함
        System.out.println("4. 반복문: 1~10 합 = " + sum);
    }

    /** 5. 메서드: 두 정수를 곱한 값을 return 하는 multiply 메서드 호출 후 출력 */
    static void practiceMethod() {
        int result = multiply(3, 5);  // multiply 메서드 호출
        System.out.println("5. 메서드: 3 * 5 = " + result);
    }
    /** 두 정수 a, b를 받아서 곱한 값을 반환 */
    static int multiply(int a, int b) {
        return a * b;
    }

    /** 6. 배열: arr에서 최댓값을 찾아서 출력 (첫 값을 max로 두고, 더 크면 갱신) */
    static void practiceArray() {
        int[] arr = { 5, 2, 9, 1, 7 };
        int max = arr[0];  // 첫 번째 값을 최댓값으로 가정
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];  // 더 크면 max 갱신
        }
        System.out.println("6. 배열: 최댓값 = " + max);
    }

    /** 7. 클래스·객체: JavaPractice.java 의 Person 클래스 참고해서 직접 만들어 보기 (선택) */

    /** 8. String: "hello", "hello" 를 equals 로 비교해서 같으면 "같음" 출력 (== 말고 equals 사용) */
    static void practiceString() {
        String a = "hello";
        String b = "hello";
        if (a.equals(b)) {  // 내용 비교
            System.out.println("8. String: 같음");
        } else {
            System.out.println("8. String: 다름");
        }
    }

    /** 9. 예외: Integer.parseInt("abc") 는 숫자가 아니므로 NumberFormatException 발생 → catch에서 "숫자 아님" 출력 */
    static void practiceException() {
        try {
            int n = Integer.parseInt("abc");  // 예외 발생
            System.out.println("9. 예외: " + n);
        } catch (NumberFormatException e) {
            System.out.println("9. 예외: 숫자 아님");
        }
    }

    /** 10. 컬렉션: List에 이름 3개 넣고, for-each(향상된 for)로 하나씩 출력 */
    static void practiceCollection() {
        List<String> names = new ArrayList<>();
        names.add("김");
        names.add("이");
        names.add("박");
        for (String name : names) {  // for-each: names의 각 요소를 name에 넣으며 반복
            System.out.println("10. 컬렉션: " + name);
        }
    }
}
