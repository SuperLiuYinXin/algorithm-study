package com.liuyinxin.HDU;

import java.io.*;
import java.util.Scanner;

public class 一只小蜜蜂_2045 {

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

    final static int maxn = 50 + 5;
    static long[] map = new long[maxn];

    public static void main(String[] args) {

        map[0] = 0;
        map[1] = 1;
        map[2] = 2;
        for (int i = 3; i < maxn; ++i) {
            map[i] = map[i - 1] + map[i-2];
        }

        Scanner in = new Scanner(is);
        int t = in.nextInt();

        while (t -- > 0) {
            int a  = in.nextInt(), b = in.nextInt();
            System.out.println(map[b-a]);
        }

    }


}
