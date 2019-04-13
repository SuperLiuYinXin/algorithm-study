package com.liuyinxin.number;

/**
 * 用双指针法, 将小的边向内移动
 * @Author: liuyinxin
 * @Date: 2019-04-12
 * @Time: 23:08
 * do the best
 */
public class 盛最多水的容器_11 {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxn = Integer.MIN_VALUE;
        while (left < right) {
            maxn = Integer.max(maxn, Math.min(height[left], height[right]) *(right - left));
            if (height[left] < height[right]) {
                ++left;
            } else
                --right;
        }
        return maxn;
    }

    public static void main(String[] args) {
        盛最多水的容器_11 s= new 盛最多水的容器_11();
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(s.maxArea(arr));

    }
}
