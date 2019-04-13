package com.liuyinxin.number;

/**
 * 学习大神的思路
 * 分左右数组
 * 左边放从左边走的最大值，右边放从右边走的最大值
 * 根据短板效应
 * 这要区两个数组相应位置的最小值,就可得出当前位置能放置的值
 * 然后剪去已经占用的地方,就是还可以放置的值
 * @Author: liuyinxin
 * @Date: 2019-04-12
 * @Time: 23:08
 * do the best
 */
public class 接雨水_42 {

    public int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int n = height.length;
        int left[] = new int[n];
        int right[] = new int[n];
        // left[i]表示i左边的最大值，right[i]表示i右边的最大值
        for(int i = 1;i<n;i++){
            left[i] = Math.max(left[i-1],height[i-1]);
            right[n - i - 1] = Math.max(right[n-i],height[n-i]);
        }
        int ans = 0;
        int level = 0;
        //只要从1..n-2
        for(int i=1;i<n-1;i++){
            level = Math.min(left[i],right[i]);
            ans += level > height[i] ? level - height[i] : 0;
        }
        return ans;
    }


    public static void main(String[] args) {
        接雨水_42 s= new 接雨水_42();
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        s.trap(arr);

    }
}
