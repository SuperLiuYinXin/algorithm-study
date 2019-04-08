package com.liuyinxin.tree;

/**
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 *
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 *
 * 以 10^9 + 7 为模，返回这些数字之和。
 */
public class 从根到叶的二进制数之和_5017 {

    long sum = 0;

    public void preForeach(TreeNode node, long value) {
        value = ((value << 1) | node.val);
        value %= (1e9 + 7);
        if (node.left == null && node.right == null) {
            sum += value;
            sum %= (1e9 + 7);
        }

        if (node.left != null)
            preForeach(node.left, value);
        if (node.right != null)
            preForeach(node.right, value);
    }

    public int sumRootToLeaf(TreeNode root) {
        if (root == null)
            return 0;
        sum = 0;
        preForeach(root, 0);
        return (int) sum;
    }

    public static void main(String[] args) {

    }
}
