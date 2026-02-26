/**
 * 5단계: 반복문 (for, while)
 * - for: 시작·조건·증감을 한 줄에. while: 조건이 참인 동안 반복
 */
public class ForWhile {
    public static void main(String[] args) {
        System.out.println("--- for ---");
        for (int i = 1; i <= 5; i++) {  // i는 1부터 5까지 1씩 증가
            System.out.println("i = " + i);
        }

        System.out.println("--- while ---");
        int j = 0;
        while (j < 3) {  // j가 3 미만인 동안 반복
            System.out.println("j = " + j);
            j++;  // 반복마다 j 증가 (없으면 무한 루프)
        }
    }
}
