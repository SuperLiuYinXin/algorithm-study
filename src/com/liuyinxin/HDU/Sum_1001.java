package com.liuyinxin.HDU;

import java.io.*;
import java.util.Scanner;

public class Sum_1001 {

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
        long n;
        while (in.hasNext() && (n = in.nextInt()) > 0){
            System.out.println( ((1 + n) * n) / 2);
            System.out.println();
        }
    }

}
