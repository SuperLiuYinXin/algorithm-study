package com.liuyinxin.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<>(0);
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode curNode = root;
        while (!treeNodes.empty() || curNode !=null){

            // 直接到curNode 的最左端
            while (curNode != null){
                treeNodes.push(curNode);
                curNode =  curNode.left;
            }

            // 如果栈不为空，就把栈订当作根节点，继续操作
            if (!treeNodes.isEmpty()){
                curNode = treeNodes.pop();
                list.add(curNode.val); // 访问当前的根节点
                curNode = curNode.right;  // 把右节点当作根节点
            }
        }

        return list;
    }

    // 第二个版本
    public List<Integer> inorderTraversalV2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode curNode = root;
        while (!nodeStack.empty() || curNode !=null){

            // 直接到curNode 的最左端
            if (curNode != null){
                nodeStack.push(curNode);
                curNode = curNode.left;
            } else {
                curNode = nodeStack.pop();
                list.add(curNode.val); // 访问
                curNode = curNode.right;
            };
        }

        return list;
    }
}
