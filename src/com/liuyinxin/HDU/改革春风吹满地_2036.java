package com.liuyinxin.HDU;

import java.io.*;
import java.util.Scanner;


public class 改革春风吹满地_2036 {

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
            int p = in.nextInt();
            if (p == 0) break;
            int[] x = new int[p],  y = new int[p];

            for (int i = 0; i < p; ++i) {
                x[i] = in.nextInt();
                y[i] = in.nextInt();
            }
            double res = 0;
            int i = 0;
            for (; i < p - 1; ++i) {
                res += 1.0 * (x[i] * y[i + 1] - x[i + 1] * y[i]);
            }
            res += 1.0 * (x[i] * y[0] - x[0] * y[i]);
            System.out.println(res / 2);
        }
    }
}
