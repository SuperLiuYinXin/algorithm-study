package com.liuyinxin.leetcode;

import java.util.ArrayList;

public class 连续差相同的数字 {

    static int [] bitarr = {0, 0, 10,100,1000,10000,100000, 1000000,10000000, 100000000,1000000000};

    // k =  0 - 10
    public int[] numsSameConsecDiff(int N, int K) {
        int end = bitarr[N + 1] - 1;
        int flag = 1;
        ArrayList<Integer> arr = new ArrayList<>(1000);
        for (int i = bitarr[N]; i <= end; ++i) {
            flag = 1;
            char[] chrarr = Integer.toString(i).toCharArray();
            for (int j = 1; j < chrarr.length; ++j) {
                if (chrarr[j] - chrarr[j-1] != K && chrarr[j-1] - chrarr[j]  != K) {
                    flag = -1;
                    break;
                }
            }
            if (flag == 1) {
                arr.add(i);
            }
        }

        int [] rtn = new int[arr.size()];
        for (int i = 0; i < arr.size(); ++i)
            rtn[i] = arr.get(i);

        return rtn;
    }


    public static void main(String[] args) {

        连续差相同的数字 s = new 连续差相同的数字();

        s.numsSameConsecDiff(3, 7);
    }
}
