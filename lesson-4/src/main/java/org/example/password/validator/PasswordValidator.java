package org.example.password.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    public static boolean isValidated(String login, String password, String confirmPassword) {
        try {
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароль и подтверждение не совпадают");
            }
            Pattern pattern = Pattern.compile("[\\w]*");
            Matcher matcherLog = pattern.matcher(login);
            if (!matcherLog.matches()) {
                throw new WrongLoginException("Логин содержит недопустимые символы");
            } else if (login.length() > 19) {
                throw new WrongLoginException("Логин слишком длинный");
            }
            Matcher matcherPass = pattern.matcher(password);
            if (!matcherPass.matches()) {
                throw new WrongPasswordException("Пароль содержит недопустимые символы");
            } else if (password.length() > 19) {
                throw new WrongPasswordException("Пароль слишком длинный");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
