package org.example;

public class MultTable {
    public static void main(String[] args) throws Exception {
        for (int multiplier1 = 1; multiplier1 <= 9; multiplier1++) {
            for (int multiplier2 = 1; multiplier2 <= 9 ; multiplier2++) {
                System.out.println(multiplier1 + " x " + multiplier2 + " = " + multiplier1*multiplier2);
            }
        }
    }
}
