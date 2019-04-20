package com.liuyinxin.dp;

/**
 *
 * 题目地址:
 * https://leetcode-cn.com/problems/unique-paths/comments/
 * @author: liuyinxin-896400010@qq.com
 * @date: 2019-04-20
 * @time: 16:48
 * do the best
 */
public class 不同路径_62 {

    // 排列组合解法
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        if (m < n) return uniquePaths(n, m);
        --m;
        --n;
        int s = m + n;
        long ans = s;
        for (int i = 2; i <= n; ++i) {
            ans = ans *  (s - i + 1);
            ans /= i;
        }
        return (int)ans;
    }


    // 动态规划解法
    public int uniquePathsDp(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }




}
