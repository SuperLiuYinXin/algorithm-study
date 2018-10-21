package com.liuyinxin.HDU;


import java.io.*;
import java.util.Scanner;

public class 亲和数_2040 {

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

        int t = in.nextInt();
        while (t-- > 0) {
            int a = in.nextInt(), b = in.nextInt();
            System.out.println(a == qing(b)? "YES" : "NO");
        }
    }

    public static int qing (int a) {
        int res = 0, j = a/2;
        for (int i = 1; i <= j; ++i) {
            if (a % i == 0) {
                res += i;
            }
        }
        return res;
    }
}
