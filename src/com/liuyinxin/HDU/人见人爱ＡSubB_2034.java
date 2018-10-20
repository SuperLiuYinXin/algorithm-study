package com.liuyinxin.HDU;

import java.io.*;
import java.util.Scanner;

public class 人见人爱ＡSubB_2034 {

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

        while (in.hasNextInt()) {
            int m, n;
            m = in.nextInt();
            n = in.nextInt();
            if ( m == 0 && n == 0) break;
//            if (m == 0 || n == 0) System.out.println("NULL");

            int len = 100 + 5;
            int[] setArr = new int[len];
//            for (int i = 0; i < len; ++i)
//                setArr[i] = -1;
            for (int i = 0; i < m; ++i)
                setArr[in.nextInt()]++;
            for (int i = 0; i < n; ++i)
                setArr[in.nextInt()]--;
            printArr(setArr, len);
        }
    }

    public static void printArr(int[] arr, int len) {
        int count = 0;
        for (int i = 0; i < len && i < arr.length; ++i) {
            if (arr[i] > 0){
                ++count;
                System.out.print(i + " ");
            }
        }
        if (count == 0)
            System.out.println("NULL");
        else
        System.out.println();
    }
}
