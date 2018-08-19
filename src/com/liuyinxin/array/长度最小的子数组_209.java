package com.liuyinxin.array;

public class 长度最小的子数组_209 {


    public static void main(String[] args) {
        长度最小的子数组_209  s = new 长度最小的子数组_209();
        int[] arr = {1,1};
        System.out.println(
                s.minSubArrayLen(3, arr)
        );
    }

    public int minSubArrayLen(int s, int[] nums) {

        if (nums.length <= 0) {
            return 0;
        }
        // 初始化的时候没有值
        int l = 0, r = -1;  // 定义滑动窗口的范围 [l ... r]  r - l + 1为长度

        int sum = 0, max = nums.length + 1;
        while ( l < nums.length ) {
            // 当小于的时候，要扩大滑块
            // 判断是否溢出
            if (r + 1< nums.length && sum < s) {
                sum+= nums[++r];
            } else{
                sum-= nums[l++];
            }
            if (sum >= s)
                max = Math.min(max, r -l + 1);
        }
        return max == nums.length + 1 ? 0 : max;
    }
}
