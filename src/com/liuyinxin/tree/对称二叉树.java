package com.liuyinxin.tree;

import javax.xml.transform.Templates;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。

 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

 1
 / \
 2   2
 / \ / \
 3  4 4  3
 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

 1
 / \
 2   2
 \   \
 3    3
 说明:

 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class 对称二叉树 {

    public static void main(String[] args) {

        对称二叉树 s = new 对称二叉树 ();

        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(2);
        tree1.left.left = new TreeNode(20);
        tree1.left.right = new TreeNode(3);
        tree1.right.left = new TreeNode(3);
        tree1.right.right = new TreeNode(20);

        System.out.println(
                s.isSymmetric(tree1)
        );
    }


    // 判断是否镜面对称，用广度优先
    public boolean isSymmetric(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) return true;

        Queue<TreeNode> curDegrade = new LinkedList<>();

        LinkedList<TreeNode> nextDegrade = new LinkedList<>();

        LinkedList<TreeNode> checkDegrade = new LinkedList<>();
        // 根先入栈，判断是否为空
        curDegrade.offer(root);

        // 判断叶子节点是否都为空
        boolean isAllLeafEmpty = true;

        TreeNode node, first, last;
        while (!curDegrade.isEmpty()) {
            node = curDegrade.poll();
            // 有null的话，为0
            if (node.left == null)
                checkDegrade.offer(new TreeNode(0));
            else {
                isAllLeafEmpty = false;
                nextDegrade.add(node.left);
                checkDegrade.offer(node.left);
            }

            if (node.right == null)
                checkDegrade.offer(new TreeNode(0));
            else {
                isAllLeafEmpty = false;
                nextDegrade.offer(node.right);
                checkDegrade.offer(node.right);
            }
            // 如果是空，则一层已经搞定
            if (!isAllLeafEmpty && curDegrade.isEmpty() ){
                isAllLeafEmpty = true; // 假设下一层都为空
                curDegrade = nextDegrade;
                nextDegrade = new LinkedList<>();
                // 开始验证是否为镜面
                while (!checkDegrade.isEmpty()){
                    // 双数加，双数减少
                    first = checkDegrade.poll(); // 第一个元素
                    last = checkDegrade.removeLast(); // 出最后一个
                    // 有一个非空或者两个的值不相等， 不可以
                    if (first.val != last.val) return false;
                }
                checkDegrade.clear();
            }
        }
        return true;
    }

    // ****************************** 递归实现  *************************************/

    public boolean isSymmetricP(TreeNode root) {
        if(root==null) return true;
        return isSymmetric(root.left,root.right);
    }

    public boolean isSymmetric(TreeNode l,TreeNode r) {
        if(l==null&&r==null) return true;
        if(l!=null&&r!=null){
            if(l.val!=r.val) return false;
            return isSymmetric(l.left,r.right)&&isSymmetric(r.left,l.right);
        }else return false;

    }
}

