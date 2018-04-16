package com.liuyinxin.number;


import java.util.regex.Matcher;

public class Reverse {

    public static void main(String[] args){
        int i = 123;

        Reverse r = new Reverse();
        System.out.println(r.reverse(i));
    }


    public int reverse(int x) {
        int result = 0;
        for (int i = x % 10; x != 0; i = x % 10){
            x = x / 10;
            try {
                result = mut(result, 10);
                result = add(result, i);
            } catch (Exception e) {
                return 0;
            }
        }
        return result;
    }

    int add(int a, int b) throws Exception {
        int result = a +b;
        if ( (a ^ result) < 0 && (b * result) < 0){
            throw new ArithmeticException("over flow");
        }
        return result;
    }

    int mut(int a, int b) throws Exception {
        int result = a * b;
        if (a != 0 && result / a != b){
            throw new ArithmeticException("over flow");
        }
        return result;
    }

}
