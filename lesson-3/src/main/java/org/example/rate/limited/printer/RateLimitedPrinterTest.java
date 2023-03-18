package org.example.rate.limited.printer;

public class RateLimitedPrinterTest {
    public static void main(String[] args) {
        Printable rateLimitedPrinter = new RateLimitedPrinter(1000);
        for (int i = 1; i < 1_000_000_000; i++) {
            rateLimitedPrinter.print(String.valueOf(i));
        }
    }
}
