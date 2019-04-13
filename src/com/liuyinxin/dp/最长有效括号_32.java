package com.liuyinxin.dp;

import java.util.Stack;

/**
 * @Author: liuyinxin
 * @Date: 2019-04-13
 * @Time: 01:06
 * do the best
 */
public class 最长有效括号_32 {

    /**
     * 根据大佬的思路来写的动态规划的思想
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();
        // 首先创建一个动态规划的
        int[] d = new int[arr.length];
        int max = 0;
        // 从尾到头开始遍历
        for (int i = arr.length - 2; i >= 0; --i) {
            // n 是下一个可能是)右括号的位置
            int n = i + 1 + d[i + 1];
            // 如果满足如下条件,如果满足当前是左括号,下一个可能的位置是右括号
            // 则长度加二
            if (n < arr.length && arr[i] == '(' && arr[n] ==')') {
                d[i] = d[i + 1] + 2;
                // 再加上下一个可能是括号已经有的长度
                // 即可
                // 应为两个括号可能相互独立
                // 所以要把这个也计算进去
                if (n + 1 < arr.length)
                    d[i] += d[n + 1];
            }
            max = Math.max(max, d[i]);
        }
        return max;
    }

    /**
     * 使用栈的方法
     * @param s
     * @return
     */
    public int longestValidParentheses3(String s) {
        int max = 0, start = 0;
        if(null == s) return 0;

        int len = s.length();

        Stack<Integer> stack = new Stack<>();
        for(int index = 0; index < len; index++){
            //遇左括号(，压栈(栈中元素为当前位置所处的下标)
            if('(' == s.charAt(index)){
                stack.push(index);
                continue;
            } else {
                if(stack.isEmpty()){
                    start = index+1;
                    continue;
                } else {
                    stack.pop();
                    if(stack.isEmpty()){
                        max = Math.max(max, index-start+1);
                    } else {
                        max = Math.max(max, index-stack.peek());
                    }
                }
            }
        }
        return max;
    }


    public int longestValidParentheses1(String s) {
        if(s==null||s.equals("")){
            return 0;
        }
        int maxLen = 0;
        int[] flag = new int[s.length()];
        for(int i  = 1;i<s.length();i++){
            if(s.charAt(i)==')'){
                //寻找该')'之前的最大匹配
                if(i - flag[i - 1] - 1 >= 0 && s.charAt(i - flag[i - 1] - 1)=='('){
                    flag[i] = flag[i - 1] + 2;
                }
                //将前面不间断匹配加起来
                if(i - flag[i] >= 0){
                    flag[i] += flag[i - flag[i]];
                }
                maxLen = flag[i]>maxLen?flag[i]:maxLen;
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        最长有效括号_32 s = new 最长有效括号_32();
        System.out.println( s.longestValidParentheses("(((())()()))()(()))("));
    }

}
