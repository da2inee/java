/**
 * 3단계: 연산자
 * 
 * 산술: + - * / %
 * 비교: == != > < >= <=
 * 논리: && || !
 */
public class Operators {
    public static void main(String[] args) {
        int a = 10, b = 3;

        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));

        System.out.println("a > b ? " + (a > b));
        System.out.println("a == 10 ? " + (a == 10));
    }
}
