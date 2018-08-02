package com.liuyinxin.tree;

public class 验证二叉搜索树 {


    public static void main(String[] args) {
        验证二叉搜索树  s = new 验证二叉搜索树 ();

        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(1);
        tree1.right = new TreeNode(3);
//        tree1.right.left = new TreeNode(6);
//        tree1.right.right = new TreeNode(20);
        System.out.println(
                s.isValidBST(tree1)
        );
    }

    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isBST(TreeNode root, long min, long max){

        if (root == null) return true;

        // 超出限定
        if (  root.val <= min || root.val >= max ) return false;

        // 如果满足的话
            // 如果是null 直接是true 防止进入递归
        return (root.left == null || isBST(root.left, min, root.val))
                // 如果
                && (root.right == null || isBST(root.right, root.val, max));
    }
}
