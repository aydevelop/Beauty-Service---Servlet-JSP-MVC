package com.epam.beautyservice.utils;

public class Router {
    public static String parse(String url) {
        String result = "";

        if (url == null) {
            result = "";
        } else {
            result = url.replaceAll("(^/)|(/$)", "");
        }
        
        return result;
    }
}
