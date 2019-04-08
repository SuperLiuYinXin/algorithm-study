package com.liuyinxin.string;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: liuyinxin
 * @Date: 2019-04-07
 * @Time: 11:14
 * do the best
 * 未通过诶,这个代码没有通过.
 * 思路:除掉要匹配的，其余的代码都必须是小写
 *
 */
public class 驼峰式匹配_5018 {

    public boolean isA (char c) {
        return 'A' <= c && c <= 'Z';
    }

    public boolean check(String s, char[] ps) {
        char[] arr = s.toCharArray();

        boolean rtn = false;
        int i = 0, j = 0;
        char c;
        while (i < arr.length) {
            c = arr[i];
            if (isA(c) ) {
                if ( !isA(ps[j]) || ps[j] != c ) {
                    return false;
                }
                while (i < arr.length && j < ps.length && arr[i] == ps[j]) {
                    ++i;
                    ++j;
                }
                if ( j < ps.length && !isA(ps[j]))
                    return false;
            } else
                ++i;
            if (j >= ps.length ) {
                while ( i < arr.length ) {
                    if (isA(arr[i++])) return false;
                }
            }
        }
        return j == ps.length;
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        char[] arr = pattern.toCharArray();

        ArrayList<Boolean> rtn = new ArrayList<>();
        for (String q: queries) {
            rtn.add(check(q,  arr));
        }
        return rtn;
    }

    public static void main(String[] args) {

        String[] arr = {"CompetitiveProgramming","CounterPick","ControlPanel"};
        ConcurrentHashMap<Character, Character> c = new ConcurrentHashMap<>();
        for (int i = 0; i < 2; ++i)
            c.put((char) ('a' + i), (char) ('a' + i));

        c.get('a');
        c.remove('a');
    }

}
