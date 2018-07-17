package com.liuyinxin.array;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

 说明：
 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

 示例 1:
 输入: [2,2,1]
 输出: 1
 示例 2:
 输入: [4,1,2,1,2]
 输出: 4
 */
public class SingleNumber {

    public static void main(String[] args) {

        SingleNumber sn = new SingleNumber();

        int[] nums = {2,2,32,32,1,4,4};

        System.out.println(
                sn.singleNumber(nums)
        );
    }

    /**
     * 很神奇的算法，利用两次异或之后值相同
     * 这样只会保留保留那个只出现一次的
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {

        int i = 0;
        for (int n: nums){
            i ^= n;
        }
        return i;
    }
}
