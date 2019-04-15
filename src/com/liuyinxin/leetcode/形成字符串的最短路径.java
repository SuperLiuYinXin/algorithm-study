package com.liuyinxin.leetcode;

/**
 *
 * 全国高校春季编程大赛题
 * 对于任何字符串，我们可以通过删除其中一些字符（也可能不删除）来构造该字符串的子序列。
 *
 * 给定源字符串 source 和目标字符串 target，找出源字符串中能通过串联形成目标字符串的子序列的最小数量。如果无法通过串联源字符串中的子序列来构造目标字符串，则返回 -1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：source = "abc", target = "abcbc"
 * 输出：2
 * 解释：目标字符串 "abcbc" 可以由 "abc" 和 "bc" 形成，它们都是源字符串 "abc" 的子序列。
 * 示例 2：
 *
 * 输入：source = "abc", target = "acdbc"
 * 输出：-1
 * 解释：由于目标字符串中包含字符 "d"，所以无法由源字符串的子序列构建目标字符串。
 * 示例 3：
 *
 * 输入：source = "xyz", target = "xzyxz"
 * 输出：3
 * 解释：目标字符串可以按如下方式构建： "xz" + "y" + "xz"。
 * @Author: liuyinxin
 * @Date: 2019-04-14
 * @Time: 14:57
 * do the best
 */
public class 形成字符串的最短路径 {

    public static void main(String[] args) {
        形成字符串的最短路径 s = new 形成字符串的最短路径();
        System.out.println( s.sol("abc", "abcac"));
        System.out.println( s.sol("abc", "acdbc"));
        System.out.println( s.sol("xyz", "xzyxz"));
    }

    public int sol(String source, String target) {
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        int time = 0;
        boolean f = false;
        int [] map = new int[26];
        for (char c : s) {
            map[c - 'a']++;
        }
        for (char c : t) {
            if (map[c - 'a'] == 0) {
                f = true;
                break;
            }
        }
        if (f) return -1;

        for (int i = 0; i < t.length;) {
            ++time;
            for (int j = 0; j < s.length; j++) {
                if (s[j] == t[i]) {
                    ++i;
                }
            }
        }
        return time;
    }

}
