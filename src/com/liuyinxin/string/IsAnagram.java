package com.liuyinxin.string;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。

 示例 1:

 输入: s = "anagram", t = "nagaram"
 输出: true
 示例 2:

 输入: s = "rat", t = "car"
 输出: false
 说明:
 你可以假设字符串只包含小写字母。

 进阶:
 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class IsAnagram {

    public static void main(String[] args) {

        IsAnagram isAnagram = new IsAnagram();

        System.out.println(
                isAnagram.isAnagram("rat", "car")
        );

    }

    public boolean isAnagram(String s, String t) {

        if (s == null || t == null || s.length() != t.length()){
            return false;
        }

        int[] arrs = new int[26];

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        for (int i = 0; i < s.length(); ++i){

            ++arrs[sArr[i] - 'a'];
            --arrs[tArr[i] - 'a'];
        }

        for (int i = 0; i < 26; ++i){

            if (arrs[i] != 0){
                return false;
            }
        }
        return true;
    }
}