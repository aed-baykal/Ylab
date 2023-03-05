import java.util.Scanner;

public class Pell {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            if (n == 0) System.out.println("0");
            else if (n == 1) System.out.println("1");
            else {
                int pellNumberN = 1;
                int pellNumberNMinus1;
                int pellNumberNMinus2 = 0;
                for (int i = 1; i < n; i++) {
                    pellNumberNMinus1 = pellNumberN;
                    pellNumberN = 2 * pellNumberNMinus1 + pellNumberNMinus2;
                    pellNumberNMinus2 = pellNumberNMinus1;
                }
                System.out.println(pellNumberN);
            }
        }
    }
}
