package com.liuyinxin.array;

import java.util.Arrays;

public class 合并两个有序数组 {

    public static void main(String[] args){
        合并两个有序数组 s =new 合并两个有序数组 ();

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        s.merge(nums1,3, nums2, 3 );

        System.out.println(Arrays.toString(nums1));
    }

    // 插入排序的一种思路， 或者直接创一个新的数组，两个数组一次插入需要的值
    public void merge(int[] nums1, int end1, int[] nums2, int end2) {

        if (end2 == 0) return;

        int start = 0;
        int index = 0;


        if (nums2[start] > nums1[end1/2]){
            start = nums1.length / 2;
        }


        int num = nums2[index];
        for (; start < end1 && index < end2; ++start){
            // 后移动
            if (nums1[start] > num){
                if (end1 - start >= 0) System.arraycopy(nums1, start, nums1, start + 1, end1 - start);
                nums1[start] = num;
                ++index;
                ++end1;
                if (index >= end2) return; // 更新参数
                num = nums2[index];
            }
        }

        if (index < end2){
            System.arraycopy(nums2, index, nums1, end1, end2 - index);
        }

    }
}
