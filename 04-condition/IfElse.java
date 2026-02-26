/**
 * 4단계: 조건문 (if, else if, else)
 * - 조건이 참인 블록만 실행되고 나머지는 건너뜀
 */
public class IfElse {
    public static void main(String[] args) {
        int score = 85;

        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else {
            System.out.println("F");
        }
    }
}
