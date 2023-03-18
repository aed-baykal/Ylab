package org.example.snils.validator;

public class SnilsValidatorImpl implements SnilsValidator {

    @Override
    public boolean validate(String snils) {
        try {
            char[] snilsCharArray = snils.toCharArray();
            if (snilsCharArray.length == 11) {
                int summ = 0;
                for (int i = 0; i < 9; i++) {
                    summ = summ + Character.digit(snilsCharArray[i], 10) * (9 - i);
                }
                if (summ == 100) {
                    summ = 0;
                } else if (summ > 100) {
                    summ = summ % 101;
                    if (summ == 100) {
                        summ = 0;
                    }
                }
                int controlNumber = Character.digit(snilsCharArray[9], 10) * 10 + Character.digit(snilsCharArray[10], 10);
                return summ == controlNumber;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }
}