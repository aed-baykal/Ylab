package org.example.file.sort;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        File dataFile = new Generator().generate("data.txt", 100);
        System.out.println(new Validator(dataFile).isSorted()); // false
        File sortedFile = new Sorter(10).sortFile(dataFile); // 10 - размер чанка
        System.out.println(new Validator(sortedFile).isSorted()); // true
    }
}
