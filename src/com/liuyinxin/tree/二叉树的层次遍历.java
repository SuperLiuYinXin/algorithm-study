package com.liuyinxin.tree;

import com.liuyinxin.list.ListNode;

import java.util.*;

public class 二叉树的层次遍历 {

    public static void main(String[] args) {
        二叉树的层次遍历 s = new 二叉树的层次遍历();

        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(1);
        tree1.right = new TreeNode(3);
        tree1.right.left = new TreeNode(10);
        tree1.right.right = new TreeNode(20);

        System.out.println(
                s.levelOrder(tree1)
        );

    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) return new ArrayList<>();
        Queue<TreeNode> next = new LinkedList<>(), cur = new LinkedList<>();
        cur.add(root);

        // 不为空的时候一直
        TreeNode node;
        List<Integer> curLevel = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        while (!cur.isEmpty()){
            node = cur.poll();
            curLevel.add(node.val);

            if (node.left != null) next.offer(node.left);
            if (node.right != null) next.offer(node.right);

            // 当前这层已经没有元素折
            if (cur.isEmpty()) {
                result.add(curLevel);
                curLevel = new ArrayList<>();
                cur = next;
                next = new LinkedList<>();
            }
        }
        return result;
    }
}
