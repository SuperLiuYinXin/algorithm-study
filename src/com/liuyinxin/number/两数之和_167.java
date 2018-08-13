package com.liuyinxin.number;

import java.util.Arrays;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 *
 * 类似题型  125 划小船
 * 有三种解法，
 *
 * 1. 可以暴力迭代
 * 2. 二分查找
 * 3. 对撞指针实现
 */
public class 两数之和_167 {

    public static void main(String[] args) {
        两数之和_167 s = new 两数之和_167();
        int[] arr = {1,2,3,4,5};
        System.out.println(
                Arrays.toString(s.twoSum(arr, 3))
        );
    }

    /**
     * 对撞指针实现
     */
    public int[] twoSum(int[] numbers, int target) {

        // 要求返回  l ！= r
        int l = 0, r= numbers.length -1; // numbers 范围  [l --- r] r= numbers.length - 1
        int sum = 0;
        for (; r > l;) {
            sum = numbers[r] + numbers[l];
            if (sum == target)
                // 要求返回的是从1开始的
                return new int[] { l + 1,r + 1};
            else if (sum < target) ++l; // 小于 向右
            else --r; // 加起来大于target 向左
        }
        return null;
    }

}
