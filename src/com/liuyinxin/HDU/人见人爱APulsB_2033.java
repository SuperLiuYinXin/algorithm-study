package com.liuyinxin.HDU;

import java.io.*;
import java.util.Scanner;


public class 人见人爱APulsB_2033 {

    public static final int debug = 1;

    static InputStream is = System.in;

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
        int t = in.nextInt();

        while (t -- > 0) {
            int[] addA = new int[3], addB = new int[3];
            for (int i = 0; i < 3; ++i) {
                addA[i] = in.nextInt();
            }
            for (int i = 0; i < 3; ++i) {
                addB[i] = in.nextInt();
            }
            add(addA, addB);
        }
    }

    static void add(int [] a, int[] b ){

        int bit = 0;
        int h, m ,s;
        s = a[2] + b[2];
        if (s > 59) {
            bit = 1;
            s %= 60;
        }
        m = a[1] + b[1] + bit;
        if (m > 59){
            bit = 1;
            m %= 60;
        }
        h = a[0] + b[0] + bit;
        System.out.println(h + " " + m + " " + s);
    }

}
