import java.util.Scanner;

public class Pell {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите индекс числа Пелля от 0 до 30: ");
            int n = scanner.nextInt();
            if ((n >= 0) && (n <= 30)){
                if (n == 0) System.out.println("Число Пелля = 0");
                else if (n == 1) System.out.println("Число Пелля = 1");
                else {
                    long pellNumberN = 1;
                    long pellNumberNMinus1;
                    long pellNumberNMinus2 = 0;
                    for (int i = 1; i < n; i++) {
                        pellNumberNMinus1 = pellNumberN;
                        pellNumberN = 2 * pellNumberNMinus1 + pellNumberNMinus2;
                        pellNumberNMinus2 = pellNumberNMinus1;
                    }
                    System.out.println("Число Пелля = " + pellNumberN);
                }
            } else System.out.println("Введенное число за пределами 0 - 30");
        }
    }
}
