package com.croplanet.memb.utils;

public class MyStringUtil {

    public static boolean isBlank(String string) {
        if (string == null) {
            return true;
        }
        if (String.valueOf(string).trim().length() == 0) {
            return true;
        }
        return false;
    }
}
