package com.liuyinxin.array;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {

        PlusOne po = new PlusOne();

        int[] d = {9};
        System.out.println(Arrays.toString(po.plusOne(d)));
    }

    public int[] plusOne(int[] digits) {

        int f = 1; // 模拟进位
        int n;

        for (int i = digits.length - 1; i>= 0 ; --i){
            n  = digits[i];
            if (n + f > 9){
                digits[i] = 0;
            } else {
                digits[i] += f;
                f = 0;
                break;
            }
        }

        if ( f > 0){
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = f;
            System.arraycopy(digits,0, newDigits, 1,digits.length);
            return newDigits;
        }
        return digits;
    }
}
