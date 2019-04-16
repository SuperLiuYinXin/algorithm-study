package com.liuyinxin.array;

/**
 * 思路:
 * 比较简单的一个题
 * 通过滑动窗口的思路
 * r一直扩大,如果不满足条件,则重新来
 * @author: liuyinxin-896400010@qq.com
 * @date: 2019-04-17
 * @time: 00:22
 * do the best
 */
public class 最长连续递增序列_674 {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int max = 1;
        int l = 0, r = 1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > nums[r - 1]) {
                r++;
                max = Math.max(max, r - l);
            } else {
                l = i;
                r = i + 1;
            }
        }
        return max;
    }
}
