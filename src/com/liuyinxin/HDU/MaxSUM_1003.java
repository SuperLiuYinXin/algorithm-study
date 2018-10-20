package com.liuyinxin.HDU;


import java.util.Scanner;


/**
 * Given a sequence a[1],a[2],a[3]......a[n], your job is to calculate the max sum of a sub-sequence. For example, given (6,-1,5,4,-7), the max sum in this sequence is 6 + (-1) + 5 + 4 = 14.
 */
public class MaxSUM_1003 {

    final static int maxn = 100000 + 5;
    static int[] arr = new int[maxn];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt(), time = 0;
        while ( line-- > 0){
            int num = scanner.nextInt();

            // 读取数组
            for (int i = 1; i <= num; ++i) {
                arr[i] = scanner.nextInt();
            }
            subSequnce(num, ++time, line);
        }
    }

    public static void subSequnce(int len, int  num, int rest) {
        int sum , maxSum;
        sum =  maxSum = arr[1];
        int curStart, maxStart, maxEnd;
        curStart = maxStart = maxEnd = 1;
        for (int i = 2; i <= len; ++i) {

            if (arr[i] > sum + arr[i]) {
                sum = arr[i];
                curStart = i;
            } else {
                sum += arr[i];
            }
            if (sum > maxSum) {
                maxSum = sum;
                maxStart = curStart;
                maxEnd = i;
            }
        }

        System.out.println("Case " + num + ":");
        System.out.println(maxSum + " " + maxStart + " " + maxEnd);
        if (rest > 0) System.out.println();

    }

}
