package com.liuyinxin.string;

import java.util.Arrays;

/**
 * 反转字符串
 请编写一个函数，其功能是将输入的字符串反转过来。

 示例：

 输入：s = "hello"
 返回："olleh"
 */
public class ReverseString {

    public static void main(String[] args) {

        ReverseString rs = new ReverseString();
        System.out.println(rs.reverseString("12"));

    }

    public String reverseString(String s) {
        int len = s.length();

        if (len <= 1){
            return s;
        }

        char[] chars = new char[len];

        int mid = len / 2;
        for (int i = 0; i <= mid ; ++i){
            chars[i] = s.charAt(len - i - 1);
            chars[len - i - 1] = s.charAt(i);
        }
        return new String(chars);
    }
}
