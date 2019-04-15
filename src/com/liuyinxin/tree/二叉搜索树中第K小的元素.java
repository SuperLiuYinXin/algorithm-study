package com.liuyinxin.tree;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 使用堆结构
 * @Author: liuyinxin
 * @Date: 2019-04-13
 * @Time: 10:55
 * do the best
 */
public class 二叉搜索树中第K小的元素 {
    private PriorityQueue<Integer> p = new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    private int k;

//    public static class Tree implements Comparable{
//         int val;
//         Tree left;
//         Tree right;
//         Tree(int x) { val = x; }
//
//        @Override
//        public int compareTo(Object o) {
//            return ((Tree)o).val - this.val;
//        }
//    }

    public void addK(TreeNode root) {
        if (p.size() < k) {
            p.add(root.val);
        } else {
            if (p.peek() > root.val) {
                p.poll();
                p.add(root.val);
            }
        }
    }

    public int getTopK() {
        return p.isEmpty() ? -1 : p.peek();
    }

    public void forEach(TreeNode root) {
        addK(root);
        if (root.left != null)
            forEach(root.left);

        if (root.right != null) {
            forEach(root.right);
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        if (root != null)
            forEach(root);
        return getTopK();
    }
}
