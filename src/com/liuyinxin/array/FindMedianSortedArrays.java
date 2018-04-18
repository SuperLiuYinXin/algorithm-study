package com.liuyinxin.array;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 *
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 中位数是 (2 + 3)/2 = 2.5
 */
public class FindMedianSortedArrays {

    public static void main(String[] args){

        int[] num1 = {1,2,10};
        int[] num2 = {3,4,5};

        FindMedianSortedArrays fmsa = new FindMedianSortedArrays();
        System.out.println(fmsa.findMedianSortedArrays(num1, num2));

    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 要让nums1 为最小
        if (nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int n = nums1.length;
        int m = nums2.length;
        int mid = n + m; // 因为引入了虚拟元素 '#', 所以总长度变成了  2*(m + n) + 2  除去索引,中值为 m + n
        int L1 = 0, R1 = 0, L2 = 0, R2 = 0, c1 = 0, c2 = 0, lo = 0, hi = 2 * n; // 引入了虚拟元素，当前长度为2n (应该为2n+1)最后一个用不上
        while (lo <= hi) {
            c1 = (hi + lo) / 2;
            c2 = mid - c1;

            L1 = c1 == 0 ?  Integer.MIN_VALUE : nums1[(c1 -1) / 2];
            R1 = c1 == 2 * n ? Integer.MAX_VALUE : nums1[ c1 / 2];
            L2 = c2 == 0 ? Integer.MIN_VALUE: nums2[(c2 - 1) / 2];
            R2 = c2 == 2 * m ? Integer.MAX_VALUE : nums2[ c2 / 2];

            if (L1 > R2) {
                hi = c1 -1;
            } else if (L2 > R1) {
                lo = c1 + 1;
            } else break;
        }

        return (Integer.max(L1, L2) + Integer.min(R1, R2))/2.0;

    }
}
