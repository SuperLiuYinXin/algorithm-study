package com.liuyinxin.leetcode;

import java.util.Stack;

public class 删除最外层的括号_5016 {




    public String removeOuterParentheses(String S) {
        Stack<Character> s = new Stack<>();
        char[] arr = S.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char c : arr) {
            if (c == '(' ) {
                s.push(c);
                if (s.size() > 1) {
                    sb.append(c);
                }
            } else {
                if (s.size() > 1) {
                    sb.append(c);
                }
                s.pop();
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }

}
