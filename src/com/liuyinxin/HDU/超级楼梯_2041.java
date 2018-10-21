package com.liuyinxin.HDU;

import java.io.*;
import java.util.Scanner;

public class 超级楼梯_2041 {

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

    final static int maxn = 40 + 5;

    static int[] fbArr = new int[maxn];


    public static void main(String[] args) {
        Scanner in = new Scanner(is);
        int t = in.nextInt();
        while (t-- > 0) {
            System.out.println(floor(in.nextInt()));
        }

    }

    public static int floor(int level) {
        if (level <= 2) return 1;
        if (fbArr[level] == 0) {
            fbArr[level] = floor(level -1) + floor(level -2);
        }
        return fbArr[level];
    }
}

