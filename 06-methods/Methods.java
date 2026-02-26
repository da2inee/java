/**
 * 6단계: 메서드 (함수)
 * - 메서드 정의 후 main에서 호출. void는 반환 없음, return은 값 반환
 */
public class Methods {
    public static void main(String[] args) {
        sayHello();  // 반환값 없는 메서드 호출
        System.out.println("합계: " + add(3, 5));  // 반환값 있는 메서드 호출
    }

    /** 반환값 없음 (void). 출력만 함 */
    static void sayHello() {
        System.out.println("안녕!");
    }

    /** 두 정수를 받아 합을 반환 */
    static int add(int a, int b) {
        return a + b;
    }
}
