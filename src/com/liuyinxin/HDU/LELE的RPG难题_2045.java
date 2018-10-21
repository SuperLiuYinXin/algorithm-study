package com.liuyinxin.HDU;


import java.io.*;
import java.util.Scanner;

public class LELE的RPG难题_2045 {

    public static int debug = 1;
    public static InputStream is = System.in;
    static {
        if (debug == 1)
            try {
                is = new FileInputStream(new File("/home/liuyinxin/code/java/algorithm-study/src/com/liuyinxin/HDU/in.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(is);
        int maxn = 60;
        long[] arr = new long[maxn];
        arr[1] = 3;
        arr[2] = 6;
        arr[3] = 6;
        int t = 0;
        while ( in.hasNextInt() && (t = in.nextInt()) > 0 ) {
            for (int i = 4; i < arr.length; ++i) {
                arr[i] = arr[i - 1] + arr[i - 2] * 2;
            }
            System.out.println(arr[t]);
        }
    }

}
