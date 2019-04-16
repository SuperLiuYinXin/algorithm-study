package com.liuyinxin.tree;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 这道题,可以用分治算法,
 * 分别计算当根节点为i = 1,2,3...n的时候,
 * 再计算其左右子树
 * 左子树的区间 [start, i - 1]
 * 右子树的区间 [i + 1, end]
 * 快速计算个数的题
 * {@link 不同的二叉搜索树_96}
 * @author: liuyinxin
 * @date: 2019-04-16
 * @time: 20:30
 * do the best
 */
public class 不同的二叉搜索树_II_95 {

    private List[][] dp;

    public int numTrees(int n) {
        if(n== 0) return 0;
        return generateTrees(n).size();
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new LinkedList<>();

        dp = new List[n + 2][n + 2];

        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        LinkedList<TreeNode> res = new LinkedList<>();
        if (start > end) { res.add(null); return res; }
        for (int i = start; i <= end; ++i) {
            List<TreeNode> leftTree = dp[start][i - 1] != null
                    ? dp[start][i - 1] : (dp[start][i - 1] = generateTrees(start, i - 1));
            List<TreeNode> rightTree = dp[i + 1][end] != null
                    ? dp[i + 1][end] : (dp[i + 1][end] = generateTrees( i + 1, end));
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode n = new TreeNode(i);
                    n.left = left;
                    n.right = right;
                    res.add(n);
                }
            }
        }
        return res;
    }

}
