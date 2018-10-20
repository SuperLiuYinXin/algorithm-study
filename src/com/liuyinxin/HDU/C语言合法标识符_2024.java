package com.liuyinxin.HDU;


import java.util.Scanner;

/**
 * 输入一个字符串，判断其是否是C的合法标识符。
 */
public class C语言合法标识符_2024 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        in.nextLine();
        String line;
        char[] lineArr;
        while (t-- > 0) {
            line = in.nextLine();
            lineArr = line.toCharArray();
            int i = 0;
            for (; i < lineArr.length; ++i) {
                char c = lineArr[i];
                if ( Character.isDigit(c) || Character.isUpperCase(c) || Character.isLowerCase(c) || c == '_'){
                    if (i < 1 && Character.isDigit(c)) {
                        i = -1;
                        break;
                    }
                } else {
                    i = -1;
                    break;
                }
            }
            System.out.println(i != -1 ? "yes" : "no");
//            System.out.println((i != -1 ? "yes" : "no") + (t > 0 ? "\n" : ""));
        }
    }
}
