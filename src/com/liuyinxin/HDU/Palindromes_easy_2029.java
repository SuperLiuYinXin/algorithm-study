package com.liuyinxin.HDU;

import java.util.Scanner;

/**
 * “回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。请写一个程序判断读入的字符串是否是“回文”。
 */
public class Palindromes_easy_2029 {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        in.nextLine();
        while (s-- > 0) {
            System.out.println(isPalindromes(in.nextLine()) ? "yes" : "no");
        }
    }

    public static boolean isPalindromes(String str){
        for (int i = 0 , j = str.length() - 1; i < j; ++i, --j) {
            if (str.charAt(i) != str.charAt(j)) return false;
        }
        return true;
    }
}
