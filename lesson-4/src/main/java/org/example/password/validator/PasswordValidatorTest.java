package org.example.password.validator;

import java.util.HashMap;
import java.util.Map;

public class PasswordValidatorTest {

    public static void main(String[] args) {
        Map<String, String> test = new HashMap<>();
        test.put("log1", "pass1");
        test.put("111", "pass1");
        test.put("log2", "111");
        test.put("___", "pass1");
        test.put("log3", "___");
        test.put("log$1", "pass1");
        test.put("log4", "pass1$");
        test.put("log555555555555555555", "pass1");
        test.put("log5", "pass111111111111111111");
        for (String s : test.keySet()) {
            System.out.println();
            System.out.println("log: " + s + "\npass: " + test.get(s) + "\nВалидность: " +
                    PasswordValidator.isValidated(s, test.get(s), test.get(s)));
        }
        System.out.println();
        System.out.println("log: " + "log1" + "\npass: " + "pass1" + "\nconfPass: " + "pass2" + "\nВалидность: " +
                PasswordValidator.isValidated("log1", "pass1", "pass2"));
    }
}
