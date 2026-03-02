/**
 * 예외 처리 예제 - try/catch/finally, 여러 catch
 *
 * 실행: javac ExceptionExample.java && java ExceptionExample
 */
public class ExceptionExample {

    /** 진입점: 5가지 예외 예시를 순서대로 실행 */
    public static void main(String[] args) {
        System.out.println("=== 1. NumberFormatException ===");
        parseExample();

        System.out.println("\n=== 2. ArrayIndexOutOfBoundsException ===");
        arrayExample();

        System.out.println("\n=== 3. NullPointerException ===");
        nullExample();

        System.out.println("\n=== 4. 여러 catch ===");
        multiCatchExample();

        System.out.println("\n=== 5. finally ===");
        finallyExample();
    }

    /** 예시 1: 문자열 "abc"를 숫자로 파싱 → NumberFormatException. catch에서 메시지 출력 */
    static void parseExample() {
        try {
            int n = Integer.parseInt("abc");  // "abc"는 숫자 아님 → 예외 발생
            System.out.println("숫자: " + n);
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아님. 메시지: " + e.getMessage());
        }
    }

    /** 예시 2: 배열 길이 3인데 arr[5] 접근 → ArrayIndexOutOfBoundsException */
    static void arrayExample() {
        int[] arr = { 10, 20, 30 };
        try {
            System.out.println("arr[0] = " + arr[0]);
            System.out.println("arr[5] = " + arr[5]);  // 인덱스 5 없음 → 예외
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("잘못된 인덱스: " + e.getMessage());
        }
    }

    /** 예시 3: null인 참조로 .length() 호출 → NullPointerException */
    static void nullExample() {
        String str = null;
        try {
            System.out.println(str.length());  // str이 null → 예외
        } catch (NullPointerException e) {
            System.out.println("null 참조.");
        }
    }

    /** 예시 4: 여러 catch - 구체적인 예외(NumberFormatException) 먼저, 그 다음 Exception */
    static void multiCatchExample() {
        try {
            int n = Integer.parseInt("가나다");  // NumberFormatException
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException 처리");
        } catch (Exception e) {
            System.out.println("기타: " + e.getMessage());
        }
    }

    /** 예시 5: finally - 예외가 나든 안 나든 한 번은 실행됨 (정리용) */
    static void finallyExample() {
        try {
            System.out.println("try 안");
            int a = 10 / 0;  // 0으로 나눔 → ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("catch: 0으로 나눔");
        } finally {
            System.out.println("finally: 항상 실행");
        }
    }
}
