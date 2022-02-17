package com.minibus.moment.util;

public class PasswordUtil {

    private static char[] charSet = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static String getRandomPassword(int len) {
        int index = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            index = (int) (charSet.length * Math.random());
            sb.append(charSet[index]);
        }
        return sb.toString();
    }
}