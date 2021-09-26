package com.epam.beautyservice.utils;

import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Translating strings from resources
 */
public class Translate {
    private Translate() {

    }

    public static String get(String line, HttpSession session) {
        String result = "";

        try {
            String loc = (String) session.getAttribute("defaultLocale");
            result = ResourceBundle.getBundle("resources", new Locale(loc)).getString(line);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }
}
