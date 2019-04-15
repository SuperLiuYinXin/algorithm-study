package com.liuyinxin;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Soltion {


    public TreeNode mkTree(Integer[] arr){

        TreeNode root = new TreeNode(arr[0]);
        TreeNode curRoot = root;
        TreeNode r ;
        for (int i = 1; i < arr.length; ++i){

            r = new TreeNode(arr[i]);

//            if (r.left = )
        }
        return null;
    }



    public static void main(String[] args) {

        Soltion s = new Soltion();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
//        root.left.left = new Tree(6);
//        root.left.right = new Tree(2);
//        root.left.right.left = new Tree(7);
//        root.left.right.right = new Tree(4);
//        root.right = new Tree(1);
//        root.right.left = new Tree(9);
//        root.right.right = new Tree(8);


        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
//        root1.left = new Tree(5);
//        root1.left.left = new Tree(6);
//        root1.left.right = new Tree(7);
//        root1.right = new Tree(1);
//        root1.right.left  = new Tree(4);
//        root1.right.right = new Tree(2);
//        root1.right.right.left = new Tree(9);
//        root1.right.right.right = new Tree(9);

        System.out.println(s.leafSimilar(root, root1));

    }


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {


        Stack<Integer> s = new Stack<>();

        visit(root1, s);

        return check(root2, s);

    }

    public void visit(TreeNode root, Stack<Integer> s){
        if (root == null){
            return;
        }

        if (root.left == null && root.right == null){
            s.add(root.val);
            return;
        }
        visit(root.left, s);
        visit(root.right, s);
    }

    public boolean check(TreeNode root, Stack<Integer> s){

        boolean r = false;
        if (root.left == null && root.right == null){
            if (s.empty() || s.pop() != root.val)
                return false;
        }

        if (root.right != null){
            r = check(root.right, s);

            if (!r){
                return false;
            }
        }

        if (root.left != null){
            r =  check(root.left, s);

            if (!r){
                return false;
            }
        }

        return true;
    }


    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

}
