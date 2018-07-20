package com.liuyinxin.array;

import java.util.ArrayList;
import java.util.Arrays;

public class Intersect {

    public static void main(String[] args) {

        Intersect i = new Intersect();

        int[] nums1 = {1};
        int[] nums2 = {1,2};

        System.out.println(Arrays.toString(i.intersect(nums1, nums2)));

    }

    // num 1 始终比nums2 小
    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }

        if (nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> result = new ArrayList<Integer>();

        int i = 0, j = 0;

        for (; j < nums2.length && i < nums1.length;){

            if (nums1[i] > nums2[j]){
                ++j;
            } else if (nums1[i] == nums2[j]){
                result.add(nums1[i]);
                ++i;
                ++j;
            } else{
                ++i;
            }
        }

        int[] arr = new int[result.size()];
        for (int l = 0; l <  result.size(); ++l){
            arr[l] = result.get(l);
        }
        return arr;
    }
}

