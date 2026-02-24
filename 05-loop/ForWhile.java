/**
 * 5단계: 반복문 (for, while)
 */
public class ForWhile {
    public static void main(String[] args) {
        System.out.println("--- for ---");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        System.out.println("--- while ---");
        int j = 0;
        while (j < 3) {
            System.out.println("j = " + j);
            j++;
        }
    }
}
