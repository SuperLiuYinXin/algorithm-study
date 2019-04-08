package com.liuyinxin.UVA;

import java.io.*;
import java.util.Scanner;


public class Main {

    public static int debug = 1;
    public static InputStream is = System.in;

    static {
        if (debug == 1)
            try {
                is = new FileInputStream(new File("/home/liuyinxin/code/java/algorithm-study/src/com/liuyinxin/UVA/in.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
    }

    static char[] s = new char[129];

    public static void main(String[] args) {

        Scanner in = new Scanner(is);
        int t =  in.nextInt();
        while (t-- > 0) {
            int top = 0;
            String sArr = in.next();
            char[] arr = sArr.toCharArray();
            for (int i = 0; i < arr.length; ++i) {
                if (top > 0) {
                    if ((s[top - 1] == '(' && arr[i] == ')') || (s[top - 1] == '[' && arr[i] == ']')) {
                        top--;
                    } else
                        s[top++] = arr[i];
                } else
                    s[top++] = arr[i];
            }
            System.out.println(top == 0 ? "YES" : "NO");
        }
    }
}
