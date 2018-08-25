package com.liuyinxin.other;

import java.util.Stack;

public class 有效的括号_20 {

    public static void main(String[] args) {
        有效的括号_20 s = new 有效的括号_20();

        System.out.println(
                s.isValid("()[]{}")
        );
    }

    public boolean isValid(String s) {
        if (s.length() <= 0) return true;
        char[] cArr = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < cArr.length; ++i){
            if (isLeft(cArr[i])) {
                stack.push(cArr[i]);
            } else if (!stack.isEmpty()){
                if (stack.pop() != pare(cArr[i])) {
                    return false;
                }
            } else return false;
        }
        return stack.isEmpty();
    }

    boolean isLeft (char c){
//        '('，')'，'{'，'}'，'['，']'
        if (c == '{' || c == '(' || c == '[') {
            return true;
        }
        return false;
    }
    char pare (char c) {
        switch (c) {
            case '}': return '{';
            case ']': return '[';
            case ')': return '(';
        }
        return 0;
    }
}
