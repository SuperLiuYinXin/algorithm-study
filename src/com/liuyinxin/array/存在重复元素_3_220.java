package com.liuyinxin.array;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 */
public class 存在重复元素_3_220 {


    public static void main(String[] args) {
        存在重复元素_3_220 s = new 存在重复元素_3_220 ();

//        int[] nums = new int[]{10,15,18,24};
        int[] nums = new int[]{0, Integer.MAX_VALUE - 1};
        int k = 1;
        int t = Integer.MAX_VALUE - 1;
        System.out.println(
                s.containsNearbyAlmostDuplicate(nums, k , t)
        );

    }

    /**
     * 使用滑动窗口解决
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        Set<Integer> s = new LinkedHashSet<>(k);

        for (int i = 0; i < nums.length; ++i){
            // 如果满了，去除左边的
            if ( i > k) s.remove(nums[i - k - 1]);
            long lv = (long)nums[i] - t, rv = (long) nums[i] + t;
            for (Integer v: s) {
                if (lv <= v && v <= rv) return true;
            }
            s.add(nums[i]);
        }
        return false;
    }
}
