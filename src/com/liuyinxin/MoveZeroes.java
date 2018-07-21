package com.liuyinxin;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

 示例:

 输入: [0,1,0,3,12]
 输出: [1,3,12,0,0]
 说明:

 必须在原数组上操作，不能拷贝额外的数组。
 尽量减少操作次数。
 */
public class MoveZeroes {

    public static void main(String[] args) {

        MoveZeroes mz = new MoveZeroes();

        int[] nums = {4,2,4,0,0,3,0,5,1,0};
        mz.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 大神的思路
    public void moveZeroes(int[] nums) {

        // k 始终记录这非最后一个非0元素的位置
        int k = 0;
        for (int i = 0; i < nums.length ; ++i){
            if (nums[i] != 0){
                if (i != k){
                    nums[k] = nums[i];
                    nums[i] = 0;
                }
                ++k;
            }
        }
    }

    /**
     *
     */




    /**
     * 自己写的，不太好，上面是大神的
     * @param nums
     * @param l
     * @param r
     * @return
     */
    int binMove(int[] nums, int l, int r){

        if (r - l <= 0)
            return l + 1;

        if (r - l < 5){
            // 排序
            int zNum = 0;
            for (int i = l; i <= r -zNum; ){
                if (nums[i] == 0){
                    for (int j = i + 1 ; j <= r - zNum ;++j){
                        nums[ j -1] = nums[j];
                    }
                    nums[r -zNum] = 0;
                    ++zNum;
                } else {
                    ++i;
                }
            }
            return r - zNum + 1;
        }

        // 二分
        int mid = (r - l) /2 + l;

        int lz = binMove(nums, l , mid);

        int rz = binMove(nums,  mid + 1, r);


        if (lz == mid + 1){
            return rz;
        }

        int i = 0;

        for (i = mid + 1; i < rz;++i){
            nums[lz++] = nums[i];
            nums[i] = 0;// 换为0
        }

        return i - 1;
    }
}
