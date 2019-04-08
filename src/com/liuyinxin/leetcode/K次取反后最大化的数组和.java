package com.liuyinxin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class K次取反后最大化的数组和 {

    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int i = 0, j = 0;
        for (; i < K && j < A.length; ++i) {
            if (A[j] < 0) {
                A[j] = -A[j];
                ++j;
                if (j < A.length && A[j] >= 0 && ( (K - j) & 1) == 0 ) {
                    i = K;
                    break;
                }
            } else
                break;
        }
        if (i < K)
            Arrays.sort(A);
        for (j = 0; i  < K && j < A.length; ++i) {
            A[j] = - A[j];
        }
        int ans = 0;
        for (i = 0; i  < A.length; ++i)
            ans += A[i];
        return ans;
    }

    public static void main(String[] args) {
        K次取反后最大化的数组和 s = new K次取反后最大化的数组和();
//        int[] A=  {2,-3,-1, 0, 1, 5,-4};
//        int[] A=  {-4,-3,-1, 0, 1, 2, 5};
        int[] A=  {3,-1,0,2};
        System.out.println(s.largestSumAfterKNegations(A, 3));

    }
}
