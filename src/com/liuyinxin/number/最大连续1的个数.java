package com.liuyinxin.number;

/**
 * 水题~
 * @author: liuyinxin-896400010@qq.com
 * @date: 2019-04-23
 * @time: 15:56
 * do the best
 */
public class 最大连续1的个数 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOne = 0, curMax = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1) {
                curMax++;
                maxOne = Math.max(curMax, maxOne);
            } else
                curMax = 0;
        }
        return maxOne;
    }
}
