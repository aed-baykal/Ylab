import java.util.Random;
import java.util.Scanner;

public class Guess {
    public static void main(String[] args) throws Exception {
        int number = new Random().nextInt(99) + 1; // здесь загадывается число от 1 до 99
        int maxAttempts = 10; // здесь задается количество попыток
        int enteredNumber;
        int attempt = 1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Я загадал число. У тебя " + maxAttempts + " попыток угадать.");
        while (attempt <= 10) {
            System.out.print("Введи число: ");
            enteredNumber = scanner.nextInt();
            if (enteredNumber == number) {
                System.out.println("Ты угадал с " + attempt + " попытки");
                break;
            }
            else if (enteredNumber > number) System.out.println("Мое число меньше! У тебя осталось " + (maxAttempts - attempt) + " попыток");
            else System.out.println("Мое число больше! У тебя осталось " + (maxAttempts - attempt) + " попыток");
            attempt++;
        }
        if (attempt == 11) System.out.println("Ты не угадал");
    }
}
