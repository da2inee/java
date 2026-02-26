/**
 * 7단계: 배열
 * - 인덱스는 0부터. length로 길이 조회
 */
public class Arrays {
    public static void main(String[] args) {
        int[] numbers = { 10, 20, 30, 40, 50 };  // 배열 리터럴로 초기화

        System.out.println("첫 번째: " + numbers[0]);  // 인덱스 0이 첫 번째
        System.out.println("길이: " + numbers.length);  // length는 필드 (괄호 없음)

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }
    }
}
