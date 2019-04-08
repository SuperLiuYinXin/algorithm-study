package com.liuyinxin.AOJ;

import java.io.*;
import java.util.Scanner;


public class ModeValue_0028 {

    public static int debug = 1;
    public static InputStream is = System.in;

    static {
        if (debug == 1)
            try {
                is = new FileInputStream(new File("/home/liuyinxin/code/java/algorithm-study/src/com/liuyinxin/AOJ/in.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) {
        int[] seq = new int[105];
        int max = Integer.MIN_VALUE;
        Scanner in = new Scanner(is);
        int num;
        while (in.hasNext()){
            num = in.nextInt();
            ++seq[num];
            max = Math.max(max, seq[num]);
        }
        for (int i = 0; i < 105; ++i) {
            if (seq[i] == max) {
                System.out.println(max);
            }
        }
    }


}
