package com.liuyinxin.HDU;

import java.io.*;
import java.util.Scanner;

/**
 * 排错问题
 */
public class 神_上帝以及老天爷_2048 {

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
        int maxn = 20 + 5;
        long[][] arr = new long[maxn][2];
        arr[1][0] = 0;
        arr[1][1] = 1;
        arr[2][0] = 1;
        arr[2][1] = 2;
        for (int i = 3; i < maxn; ++i) {
            arr[i][0] = (i - 1) * ( arr[i - 1][0] + arr[ i - 2][0]);
            arr[i][1] = i * arr[i - 1][1];
        }
        int num, t = in.nextInt();
        while (t -- > 0) {
            num = in.nextInt();
            System.out.println(String.format("%.2f%%",  ((double)arr[num][0] / arr[num][1]) * 100));
        }
    }
}
