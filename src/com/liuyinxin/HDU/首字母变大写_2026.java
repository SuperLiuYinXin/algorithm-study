package com.liuyinxin.HDU;

import java.util.Scanner;

public class 首字母变大写_2026 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            int hasBlock = 1;
            char[] strArr = str.toCharArray();
            for (int i = 0; i < str.length(); ++i) {
                char c = strArr[i];
                if (c == ' ') {
                    hasBlock = 1;
                } else if  (hasBlock == 1) {
                    hasBlock = 0;
                    strArr[i] = Character.toUpperCase(c);
                }
            }
            System.out.println(new String(strArr));
        }
    }
}
