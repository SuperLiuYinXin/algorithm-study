package com.liuyinxin;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            int num = target - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == num) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0,0};
    }

    public int[] twoSumV2(int[] nums, int target) {
        int[] arr = nums.clone();
        Arrays.sort(arr);

        int sum = 0;
        int a = 0;
        int b = 0;
        for(int i = 0, j = nums.length - 1;i < j;){
             sum = arr[i] + arr[j];
             if (sum == target) {
                 a = arr[i];
                 b = arr[j];
                 break;
             }
             if (sum < target) i++;
             else  j--;
        }

        int[] result = new int[2];
        int t = 0;
        for (int i = 0; i < nums.length; i++){
            if(a == nums[i] || b == nums[i]){
                result[t++] = i;
            }
            if (t > 1) break;
        }
        return result;
    }

}
