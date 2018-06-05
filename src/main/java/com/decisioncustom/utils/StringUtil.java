package com.decisioncustom.utils;

import java.util.Random;

public class StringUtil {

    /**
     * 随机生成指定长度的字符串
     * 
     * @param length 生成字符串的长度
     * @return
     */
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 随机生成带有指定前缀的字符串
     * 
     * @param length 含有前缀的长度
     * @param prefix 前缀
     * @return
     */
    public static String getRandomString(int length, String prefix) {
        int len = length - prefix.length();
        if (len > 0) {
            return prefix + getRandomString(len);
        } else {
            return getRandomString(length);
        }
    }
}
