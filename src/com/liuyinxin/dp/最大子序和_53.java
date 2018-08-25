package com.liuyinxin.dp;


public class 最大子序和_53 {

    public static void main(String[] args) {
        最大子序和_53 s = new 最大子序和_53();
        int[] arr = new int[] {-1,-2,1};
        System.out.println(
                s.maxSubArray(arr)
        );
    }

    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; ++i){
            if (sum <= 0) {
                sum  = 0;
            }
            sum += nums[i];
            max = Math.max(sum, max);
        }
        return max;
    }
}
