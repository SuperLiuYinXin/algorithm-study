package com.liuyinxin.leetcode;

/**
 * 有序数组中的缺失元素
 *
 * 输入：A = [4,7,9,10], K = 1
 * 输出：5
 * 解释：
 * 第一个缺失数字为 5 。
 * 示例 2：
 *
 * 输入：A = [4,7,9,10], K = 3
 * 输出：8
 * 解释：
 * 缺失数字有 [5,6,8,...]，因此第三个缺失数字为 8 。
 * 示例 3：
 *
 * 输入：A = [1,2,4], K = 3
 * 输出：6
 * 解释：
 * 缺失数字有 [3,5,6,7,...]，因此第三个缺失数字为 6 。
 *
 * @author: liuyinxin-896400010@qq.com
 * @date: 2019-04-21
 * @time: 15:01
 * do the best
 */
public class 有序数组中的缺失元素 {


    public int missingElement(int[] nums, int k) {
        int a = 0, start = nums[0], cur = nums[0];
        for (int i = 1; i < nums.length && a < k; ) {
            if (cur + 1!= nums[i]) {
                cur++;
                a++;
            } else {
                cur = nums[i];
                ++i;
            }
        }
        while (a <= k){
            cur++;
            a++;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 7 , 9, 10};
        有序数组中的缺失元素 m = new 有序数组中的缺失元素();
        m.missingElement(arr, 3);

    }
}
