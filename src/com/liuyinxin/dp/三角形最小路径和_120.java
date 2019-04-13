package com.liuyinxin.dp;

import java.util.List;

/**
 * @Author: liuyinxin
 * @Date: 2019-04-08
 * @Time: 17:56
 * do the best
 * @link <a href="https://leetcode-cn.com/problems/triangle/">三角形最小路径和_120 </a>
 */
public class 三角形最小路径和_120 {

    /**
     * 思路:
     * 这个题类似于背包问题
     * 代码和背包问题也很相似
     * @param triangle
     * @return
     */

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() <= 0) return 0;
        int[][] dp = new int[triangle.size()][triangle.size()];
        List<Integer> l =  triangle.get(triangle.size() - 1);
        for (int i = 0; i < l.size(); ++i) {
            dp[triangle.size() -1][i] = l.get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; --i) {
            l = triangle.get(i);
            for (int j = 0; j < l.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + l.get(j);
            }
        }
        return dp[0][0];
    }

    /**
     * 使用一维数组
     * 这里是学习大神的思路
     * @param triangle
     * @return
     */
    public int minimumTotal_1(List<List<Integer>> triangle) {
        if (triangle.size() <= 0) return 0;
        int[] dp = new int[triangle.size() + 1];
        List<Integer> l;
        for (int i = triangle.size() - 1; i >= 0; --i) {
            l = triangle.get(i);
            // 直接使用的是上一层的，可以减少很多
            for (int j = 0; j < l.size(); j++) {
                //这里的dp[j] 使用的时候默认是上一层的，赋值之后变成当前层
                dp[j] = Math.min(dp[j], dp[j + 1]) + l.get(j);
            }
        }
        return dp[0];
    }
}
