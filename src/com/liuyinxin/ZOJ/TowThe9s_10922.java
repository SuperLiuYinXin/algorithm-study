package com.liuyinxin.ZOJ;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class TowThe9s_10922 {

    public static int debug = 1;
    public static InputStream is = System.in;

    static {
        if (debug == 1)
            try {
                is = new FileInputStream(new File("/home/liuyinxin/code/java/algorithm-study/src/com/liuyinxin/ZOJ/in.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
    }

    static int getSum (int base, int num){
        int res = 0;
        while (num > 0) {
            res  += num % base;
            num  /= base;
        }
        return res;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(is);
        int n;
        while (in.hasNext()) {
            String numStr = in.next();
            char[] numArr = numStr.toCharArray();
            if (numArr[0] == '0') break;
            int mod = 0, sum= 0;
            for (int i = 0; i < numArr.length; ++i) {
                sum += numArr[i] - '0';
                mod = (mod * 10 + numArr[i] - '0') % 9;
            }
            if (mod == 0) {
                int d = 1;
                while (sum > 9) {
                    ++d;
                    int t = sum;
                    sum = 0;
                    while (t > 0) {
                        sum += t % 10;
                        t /= 10;
                    }
                }
                System.out.println(numStr + " is a multiple of 9 and has 9-degree " + d + ".");
            } else {
                System.out.println(numStr + " is not a multiple of 9.");
            }
        }
    }
}
