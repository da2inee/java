/**
 * 7단계: 배열
 * - 인덱스는 0부터 시작, length로 길이 조회
 * - for / for-each 로 순회 가능
 */
public class Arrays {
    public static void main(String[] args) {
        // 1) 배열 선언 + 초기화 (리터럴 방식)
        int[] numbers = { 10, 20, 30, 40, 50 };

        // 2) 인덱스 접근 + 길이 확인
        System.out.println("첫 번째: " + numbers[0]);      // 인덱스 0이 첫 번째 요소
        System.out.println("길이: " + numbers.length);     // length는 메서드가 아닌 필드

        // 3) for 인덱스 순회
        System.out.println("\n--- for 인덱스 순회 ---");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }

        // 4) for-each 순회 (값만 필요할 때 간단)
        System.out.println("\n--- for-each 순회 ---");
        for (int n : numbers) {
            System.out.println("값: " + n);
        }

        // 5) 배열에서 합계 / 최댓값 구하기
        int sum = 0;
        int max = numbers[0];
        for (int n : numbers) {
            sum += n;
            if (n > max) {
                max = n;
            }
        }
        System.out.println("\n합계: " + sum);
        System.out.println("최댓값: " + max);

        // 6) 2차원 배열 예시
        int[][] matrix = {
            { 1, 2, 3 },
            { 4, 5, 6 }
        };
        System.out.println("\n--- 2차원 배열 ---");
        System.out.println("matrix[1][2] = " + matrix[1][2]); // 6
    }
}
