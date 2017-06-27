package com.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Pattern;


/**
 * Created by ellen on 17-3-7.
 * 对x年y月的第z周，请给出该周的周一至周日的时间。注意：
 * 1）周次从周一至周日算为一周；
 * 2）当天不在本月的，算入上一月的周次，例如：2017年2月1日，算入2017年1月的第5周；
* */

public class QuestionTwo {
    private static Scanner in;
    private static String x, y, z;//年 月 周

    public static void main(String... args) {
        getTime();
    }

    private static void getTime() {
        in = new Scanner(System.in);
        System.out.println("请如输入年份");
        String reg_Y = "\\d{4}";
        String reg_M = "(?:0[1-9]|1[0-2])$";
        String reg_W = "[12345]";
        do {
            try {
                x = in.next();

            } catch (Exception e) {
                x = "";

            } finally {
                if (!Pattern.matches(reg_Y, x)) {
                    System.out.println("输入年份错误");
                }
            }
        } while (!Pattern.matches(reg_Y, x));

        System.out.println("请如输入月份");
        do {
            try {
                y = in.next();
                if (y.length() == 1) {
                    y = "0" + y;
                }

            } catch (Exception e) {
                y = "";

            } finally {
                if (!Pattern.matches(reg_M, y)) {
                    System.out.println("输入月份错误： 1～12");
                }
            }
        } while (!Pattern.matches(reg_M, y));

        System.out.println("请输入周数");
        do {
            try {
                z = in.next();

            } catch (Exception e) {
                z = "";

            } finally {
                if (!Pattern.matches(reg_W, z)) {
                    System.out.println("输入周数错误 ：1～5");
                }
            }
        } while (!Pattern.matches(reg_W, z));
        System.out.print("您输入的是："+x+"年"+y+"月"+"第"+z+"周,此时,");
        getMyCalendar(x+"-"+y+"-01");

    }


    private static void getMyCalendar(String date_str) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(date_str);
            Calendar calendar = new GregorianCalendar();
            calendar.setFirstDayOfWeek(Calendar.MONDAY);//设置周一为第一天
            calendar.setTime(date);

            calendar.set(Calendar.DAY_OF_WEEK_IN_MONTH,Integer.parseInt(z));//设置周次

            calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek()); //周的第一天
            System.out.print( "周一是："+calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"
                    + calendar.get(Calendar.DAY_OF_MONTH)+",");

            calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() + 6);//周的最后一天
            System.out.println("周日是："+calendar.get(Calendar.YEAR)+"-"+ (calendar.get(Calendar.MONTH)+1) +"-"
                    + calendar.get(Calendar.DAY_OF_MONTH)+";");
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
