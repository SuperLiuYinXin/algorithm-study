package com.liuyinxin.HDU;

import java.io.*;
import java.util.Scanner;

public class 人见人爱AMutB_2035 {

    public static int debug = 1;

    public static InputStream is = System.in;

    static {

        if (debug == 1) {
            try {
                is = new FileInputStream(new File("/home/liuyinxin/code/java/algorithm-study/src/com/liuyinxin/HDU/in.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(is);

        while (in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (a == 0 && b == 0) break;
            System.out.println(power(a, b, 1000));
        }
    }

    public static long  power(long a, long b, long mod) {
        long res = 1;
        while (b > 0) {
            if ((b & 1 ) == 1) res = res * a % mod;
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
}
