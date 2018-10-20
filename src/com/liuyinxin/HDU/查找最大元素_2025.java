package com.liuyinxin.HDU;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 对于输入的每个字符串，查找其中的最大字母，在该字母后面插入字符串“(max)”。
 */
public class 查找最大元素_2025 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        final int maxn = 400 + 5;

        while ( in.hasNext()) {
            String str =  in.nextLine();
            char[] strArr = str.toCharArray();

            char max = 'a';
            int count = 0;
            for (char c: strArr) {
                if (c > max)
                    max = c;
            }

            char[] newArr =  new char[maxn];

            int j = 0;
            for (int i = 0; i < strArr.length; ++i, ++j) {

                newArr[j] = strArr[i];
                if (strArr[i] == max) {
                    newArr[++j] = '(';
                    newArr[++j] = 'm';
                    newArr[++j] = 'a';
                    newArr[++j] = 'x';
                    newArr[++j] = ')';
                }
            }
            System.out.println(new String(newArr, 0, j));
        }
    }
}
