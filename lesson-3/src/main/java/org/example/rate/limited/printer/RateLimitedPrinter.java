package org.example.rate.limited.printer;

public class RateLimitedPrinter implements Printable{

    private final int interval;
    private long lastCall = 0L;

    public RateLimitedPrinter(int interval) {
        this.interval = interval;
    }

    @Override
    public void print(String message) {
        long currentTime = System.currentTimeMillis();
        if ((currentTime - lastCall) > interval) {
            System.out.println("Метод print() был вызван " + message + " раз");
            if (lastCall > 0L) {
                System.out.println("С последнего успешного вызова прошло " + (currentTime - lastCall) + " мс");
            } else {
                System.out.println("Первый успешный вызов метода print()");
            }
            lastCall = System.currentTimeMillis();
        }
    }
}
