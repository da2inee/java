/**
 * 6단계: 메서드 (함수)
 * 메서드 정의 → main에서 호출
 */
public class Methods {
    public static void main(String[] args) {
        sayHello();
        System.out.println("합계: " + add(3, 5));
    }

    static void sayHello() {
        System.out.println("안녕!");
    }

    static int add(int a, int b) {
        return a + b;
    }
}
