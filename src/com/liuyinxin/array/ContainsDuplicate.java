package com.liuyinxin.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {

        ContainsDuplicate cd = new ContainsDuplicate();

        int[] nums = {1,1,1,3,3,4,3,2,4,2};

        System.out.println(

                cd.containsDuplicate(nums)
        );


    }

    /**
     * 此方法用了一个Set 是一个无序集合 如果添加重复的书进去会失败
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> numSet = new HashSet<>(nums.length / 2);
        for (int num : nums){
            int l = numSet.size();
            numSet.add(num);
            if (l == numSet.size()){
                return true;
            }
        }
        return false;
    }

    /**
     * 两层循环，和前面的数字去比较，空间占用小，
     * @param nums
     * @return
     */
    public boolean containsDuplicateSample(int[] nums) {

        for (int i = 1; i < nums.length; ++i){
            for (int j = i -1; j >=0; --j){
                if (nums[i] > nums[j]){
                    break;
                }
                if (nums[i] == nums[j]){
                    return true;
                }
            }
        }

        return false;
    }
}
