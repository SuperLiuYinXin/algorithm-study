package com.liuyinxin.leetcode;

/**
 * 按字典序排列最小的等效字符串
 *
 * @author: liuyinxin-896400010@qq.com
 * @date: 2019-04-21
 * @time: 15:09
 * do the best
 */
public class 按字典序排列最小的等效字符串 {

    char[] arr = null;

    public void init() {
        if (arr == null)
            arr = new char[26];
        for(int i = 0; i < 26; ++i) {
            arr[i] = (char) ('a' + i);
        }
    }

    public void union(char a, char b) {
        if (a==b)return;
        a = find(a);
        b = find(b);
        char min = a > b ? b : a;
        char max = a > b ? a : b;
        arr[max - 'a'] = min;
    }

    public char find(char c) {
        while (arr[c - 'a'] != c){
            c = arr[c - 'a'];
        }
        return c;
    }


    public String smallestEquivalentString(String A, String B, String S) {

        char[] aArr = A.toCharArray();
        char[] bArr = B.toCharArray();
        char[] sArr =S.toCharArray();
        init();

        for (int i = 0; i <aArr.length; ++i){
            union(aArr[i], bArr[i]);
        }


        char[] par = new char[26];
        for (int i = 0; i < 26; ++i) {
            par[i] = find((char) ('a' + i));
        }

//        System.out.println(par);
//        init();
//        System.out.println(arr);

        for (int i = 0; i <sArr.length; ++i) {
            if (sArr[i] > par[sArr[i] - 'a']) {
                sArr[i] = par[sArr[i] - 'a'];
            }
        }
        return new String(sArr);
    }

    public static void main(String[] args) {
        按字典序排列最小的等效字符串 m = new 按字典序排列最小的等效字符串();
        System.out.println(
        m.smallestEquivalentString("leetcode", "programs", "sourcecode"));

    }

}
