package org.example.sequence;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SequenceTest {
    public static void main(String[] args) {
        SequenceGenerator sequenceGenerator = new SequenceGeneratorImpl();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите количество элементов последовательностей от 1 до 30: ");
            int n = scanner.nextInt();
            if (n > 0 && n <= 30) {
                sequenceGenerator.a(n);
                System.out.println("_________________");
                sequenceGenerator.b(n);
                System.out.println("_________________");
                sequenceGenerator.c(n);
                System.out.println("_________________");
                sequenceGenerator.d(n);
                System.out.println("_________________");
                sequenceGenerator.e(n);
                System.out.println("_________________");
                sequenceGenerator.f(n);
                System.out.println("_________________");
                sequenceGenerator.g(n);
                System.out.println("_________________");
                sequenceGenerator.h(n);
                System.out.println("_________________");
                sequenceGenerator.i(n);
                System.out.println("_________________");
                sequenceGenerator.j(n);
            } else {
                System.out.println("Вы ввели число за пределами предложенного диапазона.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Введенные данные не соответствуют запросу.");
        }
    }
}
