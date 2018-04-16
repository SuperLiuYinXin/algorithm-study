package com.liuyinxin;

import java.util.Arrays;

public class RemoveDuplicates {

    private static int[] test = {1,1,2,3,3,4};

    public static void main(String[] args) {
        RemoveDuplicates remove= new RemoveDuplicates();
        System.out.println(remove.removeDuplicates(test));

    }

    public int removeDuplicates (int[] nums) {
        if (nums == null){
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }
        int j = 1;
        for (int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

}
