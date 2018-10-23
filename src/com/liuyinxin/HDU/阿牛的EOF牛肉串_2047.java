package com.liuyinxin.HDU;

import java.io.*;
import java.util.Scanner;

public class 阿牛的EOF牛肉串_2047 {

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

        int maxn = 45;
        long[] map = new long[maxn];
        map[1] = 3;
        map[2] = 8;
        for (int i = 3; i < maxn; ++i) {
            map[i] = map[i - 1] * 2 + map[i - 2] * 2;
        }
        Scanner in = new Scanner(is);
        while (in.hasNextInt()) {
            System.out.println(map[in.nextInt()]);
        }
    }
}
