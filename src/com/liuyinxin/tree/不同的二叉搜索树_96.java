package com.liuyinxin.tree;

/**
 *
 * 不同的二叉搜索树的个数
 * 是一个<strong>卡特兰数</strong>,学习的链接 <a href="http://lanqi.org/skills/10939/">卡特兰数</a>
 * <br/>
 * 通项公式为　C1 = 1 C(n+1) = Sum( C(i) * C(n - i)) (s.t  i = 0...n)
 * 大佬的思路解释:
 * 假设n个节点存在二叉排序树的个数是G(n)，
 * 1为根节点，2为根节点，...，n为根节点，
 * 当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，
 * 同理当2为根节点时，其左子树节点个数为1，右子树节点为n-2，
 * 所以可得G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
 * 但是这个只能求解个数
 * 计算树长什么样子的
 * {@link 不同的二叉搜索树_II_95}
 * @Author: liuyinxin
 * @Date: 2019-04-16
 * @Time: 21:11
 * do the best
 */
public class 不同的二叉搜索树_96 {

    public int numTrees(int n) {
        if(n== 0) return 0;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

}
