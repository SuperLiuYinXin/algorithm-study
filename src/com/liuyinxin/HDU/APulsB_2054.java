package com.liuyinxin.HDU;

import java.io.*;
import java.math.BigDecimal;
import java.util.Scanner;

// 大数题
public class APulsB_2054 {

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

        while (in.hasNext()) {
            BigDecimal a = in.nextBigDecimal();
            BigDecimal b = in.nextBigDecimal();
            System.out.println(a.compareTo(b) == 0 ? "YES" : "NO");
        }

    }
}
