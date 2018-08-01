package com.liuyinxin.tree;

public class 二叉树的最大深度 {

    public static void main(String[] args) {
        二叉树的最大深度 s = new 二叉树的最大深度 ();

        TreeNode tree1 = new TreeNode(3);
        tree1.left = new TreeNode(9);
        tree1.right = new TreeNode(20);
//        tree1.right.left = new TreeNode(15);
//        tree1.right.right = new TreeNode(7);
//        tree1.right.right.right = new TreeNode(8);

        System.out.println(
                s.maxDepth(tree1)
        );

    }

    public int maxDepth(TreeNode root) {

        if (root == null) return 0;

        int leftDepth = root.left == null ?
                0 : maxDepth(root.left);

        int rightDepth = root.right == null ?
                0 : maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;

    }

}
