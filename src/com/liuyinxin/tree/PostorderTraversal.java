package com.liuyinxin.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<>(0);
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root; // 当前的根节点
        TreeNode last = null;
        while (curNode != null || !stack.isEmpty()){
            if (curNode != null){
                stack.push(curNode);
                curNode = curNode.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right != null &&  last != peek.right) {
                    curNode = peek.right;
                } else {
                    peek = stack.pop();
                    list.add(peek.val);
                    last = peek;
                }
            }
        }
        return list;
    }

}
