/**
 * 7단계: 배열
 */
public class Arrays {
    public static void main(String[] args) {
        int[] numbers = { 10, 20, 30, 40, 50 };

        System.out.println("첫 번째: " + numbers[0]);
        System.out.println("길이: " + numbers.length);

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }
    }
}
