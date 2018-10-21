package com.liuyinxin.HDU;

import java.io.*;
import java.util.Scanner;

public class 不容易系列之二_2042 {

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

        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long y = 3;
            while (n -- > 0) {
                y = (y - 1) << 1;
            }
            System.out.println(y);
        }

    }

}
