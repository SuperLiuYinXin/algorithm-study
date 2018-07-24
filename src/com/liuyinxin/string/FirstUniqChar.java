package com.liuyinxin.string;

import java.util.Arrays;

/**
 *  字符串中的第一个唯一字符
 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

 案例:
 s = "leetcode"
 返回 0.
 s = "loveleetcode",
 返回 2.

 注意事项：您可以假定该字符串只包含小写字母。
 */
public class FirstUniqChar {


    public static void main(String[] args) {

        FirstUniqChar fuc = new FirstUniqChar();
        System.out.println(

                fuc.firstUniqChar("bb")
        );

    }


    public int firstUniqChar(String s) {

        int [] arrs = new int[26];

        for (int i = 0; i < s.length(); ++i){
            ++arrs[s.charAt(i) - 'a'];
        }

        for (int i = 0; i < s.length(); ++i){

            if (arrs[s.charAt(i) - 'a'] == 1){

                return i;
            }
        }
//        System.out.println(Arrays.toString(arrs));
        return -1;
    }
}
