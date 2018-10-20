package com.liuyinxin.HDU;

import java.util.Scanner;

/**
 * A number sequence is defined as follows:
 *
 * f(1) = 1, f(2) = 1, f(n) = (A * f(n - 1) + B * f(n - 2)) mod 7.
 *
 * Given A, B, and n, you are to calculate the value of f(n).
 * 一般出现mod的地方，都会有一个循环的序列
 */
public class NumberSequence_1005 {


    public static final int maxn = 1000 + 10;
    public static long [] arr = new long[maxn];


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int a, b, n ,i;
        while (true) {
            a = input.nextInt();
            b = input.nextInt();
            n = input.nextInt();
            if (a == 0 && b == 0 && n == 0) break;
            arr[1] = 1;
            arr[2] = 1;


            // 循环
            for (i = 3; i <= 55; ++i){
                arr[i] = (a * arr[i - 1] + b * arr[ i - 2]) % 7;
                if (arr[i] == 1 && arr[i - 1] == 1) {
                    break;
                }
            }
            for (int j = 1; j <= i; ++j) {
//                System.out.print(arr[j] + " ");
                if (j % 7 == 0) System.out.println();
            }
            arr[0] = arr[i - 2];
            n %= i - 2;
            System.out.println(arr[n]);
        }

    }
}
