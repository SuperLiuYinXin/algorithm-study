package com.liuyinxin.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    public static TreeNode nodeTest(){
        TreeNode root = new TreeNode(1);
        root.left = null;
        TreeNode rootRight = new TreeNode(2);
        root.right = rootRight;
        rootRight.left = new TreeNode(3);
        return root;
    }

    public static TreeNode nodeTest1(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right= new TreeNode(2);
        return root;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> treeStack = new Stack<>();
        treeStack.push(root);
        while (!treeStack.empty()) {
            TreeNode node = treeStack.pop();
            result.add(node.val);
            if (node.right != null){
                treeStack.push(node.right);
            }
            if (node.left != null){
                treeStack.push(node.left);
            }
        }
        return result;
    }
}
