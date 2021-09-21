package com.epam.beautyservice.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class Validator {

    StringBuilder error = new StringBuilder();

    public void checkEmail(String email) {
        append(valid("^.+@.+\\..+$", email) ? "" : "Email not valid");
    }

    public void checkPassword(String password) {
        append(valid("^[A-Za-z0-9]{4,24}$", password) ? "" : "Password only latin and digit with len 4-24");
    }

    public void checkName(String name) {
        append(valid("^[A-Za-z]{2,20}$", name) ? "" : "Name only latin with len 2-20");
    }

    private static boolean valid(String regex, String value) {
        return Pattern.compile(regex).matcher(value).matches();
    }

    public String getError() {
        return error.toString();
    }

    private void append(String str) {
        if (error.indexOf(str) == -1) {
            error.append(str);

            if (str.length() > 0) {
                error.append("<br>");
            }
        }
    }

    public static boolean isDateValid(String date)
    {
        String DATE_FORMAT = "yyyy-MM-dd";

        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
