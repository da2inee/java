/**
 * 배열 실습용 파일
 *
 * 실행:
 *   javac ArraysPractice.java
 *   java ArraysPractice
 *
 * 각 문제의 TODO를 직접 채워 보세요.
 */
public class ArraysPractice {

    public static void main(String[] args) {
        question1();
        question2And3();
        question4And5();
        question6();
        question7();
        question8();
        question9();
        question10();
    }

    // 문제 1: 첫 값, 마지막 값, 길이 출력
    static void question1() {
        int[] nums = {3, 6, 9, 12};

        // TODO
        System.out.println("\n[문제1]");
        System.out.println("첫 번째: " + nums[0]);
        System.out.println("마지막: " + nums[nums.length - 1]);
        System.out.println("길이: " + nums.length);
    }

    // 문제 2: 합계, 문제 3: 평균
    static void question2And3() {
        int[] nums = {3, 6, 9, 12};

        // TODO
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        double avg = (double) sum / nums.length;

        System.out.println("\n[문제2,3]");
        System.out.println("합계: " + sum);
        System.out.println("평균: " + avg);
    }

    // 문제 4: 최댓값, 문제 5: 최솟값
    static void question4And5() {
        int[] arr = {5, 2, 9, 1, 7};

        // TODO
        int max = arr[0];
        int min = arr[0];
        for (int n : arr) {
            if (n > max) {
                max = n;
            }
            if (n < min) {
                min = n;
            }
        }

        System.out.println("\n[문제4,5]");
        System.out.println("최댓값: " + max);
        System.out.println("최솟값: " + min);
    }

    // 문제 6: 짝수 개수
    static void question6() {
        int[] arr = {5, 2, 9, 1, 7, 8, 10};

        // TODO
        int countEven = 0;
        for (int n : arr) {
            if (n % 2 == 0) {
                countEven++;
            }
        }

        System.out.println("\n[문제6]");
        System.out.println("짝수 개수: " + countEven);
    }

    // 문제 7: target 찾기 (있으면 인덱스, 없으면 -1)
    static void question7() {
        int[] arr = {5, 2, 9, 1, 7};
        int target = 7;

        // TODO
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                index = i;
                break;
            }
        }

        System.out.println("\n[문제7]");
        System.out.println("target(" + target + ") index: " + index);
    }

    // 문제 8: 뒤에서부터 출력
    static void question8() {
        int[] arr = {5, 2, 9, 1, 7};

        System.out.println("\n[문제8]");
        // TODO
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 문제 9: 2차원 배열 합계
    static void question9() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };

        // TODO
        int sum = 0;
        for (int[] row : matrix) {
            for (int n : row) {
                sum += n;
            }
        }

        System.out.println("\n[문제9]");
        System.out.println("2차원 배열 합계: " + sum);
    }

    // 문제 10: 배열 복사
    static void question10() {
        int[] src = {10, 20, 30};
        int[] dest = new int[src.length];

        // TODO
        for (int i = 0; i < src.length; i++) {
            dest[i] = src[i];
        }

        System.out.println("\n[문제10]");
        for (int n : dest) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
