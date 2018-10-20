package com.liuyinxin.HDU;

import java.io.*;
import java.util.Scanner;

public class 杨晖三角_2032 {

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

    final static int maxn = 30 + 5;

    static int[][] san = new int[maxn][maxn];

    public static void main(String[] args) {
        Scanner in = new Scanner(is);
        san[1][1] = 1;
        san[2][1] = 1;
        san[2][2] = 1;
        for (int i = 3; i < maxn; ++i) {
            san[i][1] = 1;
            int j = 2;
            for (; j < i; ++j) {
                san[i][j] = san[i-1][j -1] + san[i - 1][j];
            }
            san[i][j] = 1;
        }

        int num = 0;
        while (in.hasNext() && (num = in.nextInt()) > 0 ){
            for (int i = 1; i <= num; ++i) {
                for (int j = 1; j <= i; ++j) {
                    if (j > 1) System.out.print(" ");
                    System.out.print(san[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
