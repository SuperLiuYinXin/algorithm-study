package com.liuyinxin.ZOJ;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class BasicRemains_1929 {

    public static int debug = 1;
    public static InputStream is = System.in;

    static {
        if (debug == 1)
            try {
                is = new FileInputStream(new File("/home/liuyinxin/code/java/algorithm-study/src/com/liuyinxin/ZJO/in.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
    }

    public static char[] p = new char[1001];


    public static void main(String[] args) {

        Scanner in = new Scanner(is);
        int base;
        while ((base = in.nextInt()) > 0) {
            int res = solve(base, in.next(), in.next());
            printl(base, res);
        }

    }

    static void printl(int base, int res) {
        int i = 0, cpI;
        while (res > 0) {
            p[i] = (char)(res % base + '0');
            res /= base;
            ++i;
        }
        cpI = i;
        --i;
        for (int j = 0; j < i; ++j, --i) {
            char t = p[i];
            p[i] = p[j];
            p[j] = t;
        }
        System.out.println(new String(p, 0, cpI));
    }

    static int solve(int base, String pStr, String mStr) {
        char[] p = pStr.toCharArray();
        char[] m = mStr.toCharArray();
        int mNum = 0;
        for (int i =0; i < m.length; ++i)
            mNum = mNum * base + m[i] - '0';

        int res = 0;
        for (int i =0; i <p.length; ++i) {
            res = res * base + p[i] - '0';
            res %= mNum;
        }
        return res;
    }

}
