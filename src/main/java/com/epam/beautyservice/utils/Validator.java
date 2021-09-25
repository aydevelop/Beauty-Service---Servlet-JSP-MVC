package com.epam.beautyservice.utils;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class Validator {
    private static String DATE_FORMAT = "yyyy-MM-dd";
    private StringBuilder error = new StringBuilder();
    private HttpSession session;

    public Validator() {
    }

    public Validator(HttpSession session) {
        this.session = session;
    }

    public void checkEmail(String email) {
        append(valid("^.+@.+\\..+$", email) ? "" : translate("Email_not_valid"));
    }

    public void checkPassword(String password) {
        append(valid("^[A-Za-z0-9]{4,24}$", password) ? "" : translate("Password_length_2-20_and_only_Latin_letters"));
    }

    public void checkName(String name) {
        append(valid("^[A-Za-z]{2,20}$", name) ? "" : translate("Name_length_2-20_and_only_Latin_letters"));
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

    public static boolean isDateValid(String date) {


        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String translate(String line) {
        if (session != null) {
            Object loc = session.getAttribute("defaultLocale");
            if (loc != null) {
                line = ResourceBundle.getBundle("resources", new Locale((String) loc)).getString(line);
            }
        } else {
            line = line.replace("_", " ");
        }

        return line;
    }
}
