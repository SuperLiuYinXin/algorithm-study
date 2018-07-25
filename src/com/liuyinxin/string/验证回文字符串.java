package com.liuyinxin.string;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

 说明：本题中，我们将空字符串定义为有效的回文串。

 示例 1:

 输入: "A man, a plan, a canal: Panama"
 输出: true
 示例 2:

 输入: "race a car"
 输出: false
 */
public class 验证回文字符串 {

    public static void main(String[] args) {

        验证回文字符串 s = new 验证回文字符串();

        System.out.println(
                s.isPalindrome("A man, a plan, a canal: Panama")
        );
        System.out.println(
                s.isPalindrome("race a car")
        );

        System.out.println(
                s.isPalindrome("")
        );

        System.out.println(
                s.isPalindrome("\"A man\na plan\na canal: Panama\"")
        );

        System.out.println(
                s.isPalindrome(" ")
        );
        System.out.println(
                s.isPalindrome(".;")
        );
        System.out.println(
                s.isPalindrome("a.;b")
        );
        System.out.println(
                s.isPalindrome("0p")
        );

    }

    public boolean isPalindrome(String s) {

        char[] chars = s.toCharArray();

        int i = 0, j = chars.length - 1;

        char l, r;
        for (; i < j; ++i,--j){

            for (;!isValueChar(chars[i]) && i < j; ++i);

            for (;!isValueChar(chars[j]) && i < j; --j);

            l = chars[i];

            r = chars[j];

            if ( 'A' <= l && l <= 'Z'){
                l = (char) (l + 32);
            }

            if ( 'A' <= r && r <= 'Z'){
                r = (char) (r + 32);
            }

            if (l != r){
                return false;
            }
        }
        return true;

    }

    boolean isValueChar(char c){
        return   ('a' <= c && c <= 'z' ) || ('A'<= c && c <= 'Z') || ('0' <= c && c <= '9');
    }

}
