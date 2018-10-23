package com.liuyinxin.HDU;


import java.io.*;
import java.util.Scanner;
public class 骨牌铺方格_2046 {

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
        int manx = 50 + 5;
        long[] map = new long[manx];
        map[1] = 1;
        map[2] = 2;
        map[3] = 3;
        for (int i = 4; i < manx; ++i) {
            map[i] = map[i - 1] + map[i - 2];
        }
        while (in.hasNextInt()) {
            System.out.println(map[in.nextInt()]);
        }
    }

}
