package com.example.registerlogin.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_VIETNAMESE_PHONE_REGEX =
            Pattern.compile("^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$", Pattern.CASE_INSENSITIVE);

    public static boolean checkEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static boolean checkVietnamesePhone(String phone) {
        Matcher matcher = VALID_VIETNAMESE_PHONE_REGEX.matcher(phone);
        return matcher.find();
    }
}
