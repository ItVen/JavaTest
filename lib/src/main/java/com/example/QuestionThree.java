package com.example;

import java.io.UnsupportedEncodingException;

/**
 * Created by ellen on 17-3-7.
 * 将UTF8编码值为 0x16F00 的字符转换为UTF16 Surrogate Pair
 */

public class QuestionThree {
    private static String hexString="0x16F00";
    public static  void main(String ... args){
        try {
            String str_8=toStringHex(hexString);
            String str_16 = new String(str_8.getBytes("utf-8"),"utf-16");
            System.out.print("该编码的字符是："+str_8+",转码后的字符是："+str_16);
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }


    /**
     * 转换十六进制编码为字符串
     * */
    public static String toStringHex(String s) {
        if ("0x".equals(s.substring(0, 2))) {
            s = s.substring(2);
        }
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(
                        i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            s = new String(baKeyword, "utf-8");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }
}

