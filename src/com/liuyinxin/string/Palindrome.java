package com.liuyinxin.string;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Stack;

public class Palindrome { // 判断是否是回文数

    public static void main(String[] args){

//        Integer n = 12321;
        Integer n = 1;
        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome(n));
    }

    final static int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE };

    static int sizeOfInt(int x) {
        for (int i = 0;; i++)
            if (x <= sizeTable[i])
                return i + 1;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int len = sizeOfInt(x);
        int mid = len/2;
        int odd = len % 2 == 0 ? 0 : 1;
        Stack stack = new Stack<Integer>();
        for (int i = len - odd ; i > mid; --i){
            stack.push(x % 10);
            x /= 10;
        }
        if (odd == 1){
            x /= 10;
        }
        for (int i = mid; i > 0; --i){
            if ((Integer)stack.pop() != x % 10){
                return false;
            }
            x /= 10;
        }
        return true;
    }

    // Copy  120ms  isBetter
    public boolean isPalindromeV2(int x) {

        // 负数不是回访数字
        if (x < 0) {
            return false;
        }

        // 数字逆转后的值，为了不使用溢出采用long
        long reverse = 0;
        int tmp = x;

        // 求逆转后的值
        while (tmp != 0) {
            reverse = reverse * 10 + tmp % 10;
            tmp /= 10;
        }

        // 判断是否是回文数字
        return x == reverse;
    }


}
