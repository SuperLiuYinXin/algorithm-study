package com.liuyinxin.string;

import java.util.Arrays;

public class 最长公共前缀 {

    public static void main(String[] args) {
        最长公共前缀 s = new 最长公共前缀();

//        String[] sarr = {"flower","flow","flight"};
//        String[] sarr = {"flower","flow","fiight", "123          123123"};
//        String[] sarr = {"flower"};
        String[] sarr = {"a", "ac"};

        System.out.println(
                s.longestCommonPrefix(sarr)
        );
    }

    public String longestCommonPrefix(String[] strs) {

        if (strs.length <= 0 || strs[0].length() <= 0){
            return "";
        } else if (strs.length == 1){
            return strs[0];
        }
        char[] carr = strs[0].toCharArray();
        int endI = carr.length - 1;
        for (int i = 1; i < strs.length; ++i){
            if (strs[i].length()  <= 0){
                return "";
            }
            int end = Math.min(endI, strs[i].length() - 1);
            endI = end;
            int j = 0;
            for (; j <= end; ++j){
                if (carr[j] != strs[i].charAt(j)){
                    endI  = Math.min(endI, j -1);
                    if (endI < 0 ){
                        return "";
                    }
                    break;
                }
            }
        }

        char[] rst = new char[endI + 1];
        System.arraycopy(carr, 0, rst, 0, endI + 1);
        return new String (rst);
    }
}
