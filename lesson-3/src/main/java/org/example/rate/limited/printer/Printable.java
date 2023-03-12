package org.example.rate.limited.printer;

public interface Printable {
    /**
     * Метод печати сообщений.
     * @param message - сообщение, передаваемое на печать.
     */
    void print(String message);
}
