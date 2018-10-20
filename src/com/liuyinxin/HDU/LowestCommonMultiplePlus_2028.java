package com.liuyinxin.HDU;

import java.util.Scanner;

public class LowestCommonMultiplePlus_2028 {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt(), s = 1;
            if (n  == 0) continue;
            s = in.nextInt();

            for (int i = 1; i < n; ++i){
                s = gbd(in.nextInt(), s);
            }
            System.out.println(s);
        }
    }


    public static int gcd(int a,  int b) {
        if  (a < b) return gcd(b ,a);

        int t = 0;
        while ( b != 0) {
            t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static int gbd (int a ,int b) {
        return a / gcd(a, b) * b;
    }
}
