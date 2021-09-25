package com.epam.beautyservice.utils;

public class Router {
    private Router() {
    }

    public static String parse(String url) {
        String result = "";

        if (url == null) {
            result = "";
        } else {
            result = url.replaceAll("(^/)|(/$)", "");
        }

        return result;
    }

    public static String getSegment(String url) {
        String segment = url.replaceAll("^.+\\/\\/.+?\\/", "");
        segment = "/" + segment;
        return segment;
    }

    public static String format(String path) {
        return "path " + (path.equals("") ? "/" : path);
    }
}
