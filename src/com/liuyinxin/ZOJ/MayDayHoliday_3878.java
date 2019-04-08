package com.liuyinxin.ZOJ;

import java.io.*;
import java.util.Scanner;

public class MayDayHoliday_3878 {

    public static int debug = 1;
    public static InputStream is = System.in;

    static {
        if (debug == 1)
            try {
                is = new FileInputStream(new File("/home/liuyinxin/code/java/algorithm-study/src/com/liuyinxin/ZOJ/in.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
    }

    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 !=0) || year % 400 == 0;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(is);
        int[] holiday =  new int[]{6, 9, 5, 5, 5, 5, 6};
        int row = 2, year, day;
        int t = in.nextInt();
        while (t-- > 0) {
            year = in.nextInt();
            year = year - 1928;
            day = (row + 365  * year  + year / 4) % 7;
            System.out.println(holiday[day]);
        }
    }
}
