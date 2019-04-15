package com.liuyinxin.leetcode;

/**
 *
 * 给定一个数字 N，当它满足以下条件的时候返回 true：
 *
 * 把原数字旋转180°以后得到新的数字。
 *
 * 如 0, 1, 6, 8, 9 旋转 180° 以后，得到了新的数字 0, 1, 9, 8, 6 。
 *
 * 2, 3, 4, 5, 7 旋转 180° 后,得到的不是数字。
 *
 * 易混淆数字 (confusing number) 就是一个数字旋转180°以后，得到和原来不同的数字，且新数字的每一位都是有效的。
 * @Author: liuyinxin
 * @Date: 2019-04-14
 * @Time: 16:31
 * do the best
 */
public class 混淆数字 {

    public boolean confelusingNumber(int N) {
        int num = 0, o = N, r;

        boolean f = true;
        while (o > 0 && f) {
            r =  o % 10;
            switch (r) {
                case 0: r = 0; break;
                case 1: r= 1; break;
                case 9: r = 6; break;
                case 8: r = 8; break;
                case 6: r = 9; break;
                default:
                    r = -1;
            }
            if (r == -1) f = false;
            num =  num * 10 + r;
            o /= 10;
        }
        return f && num != N;
    }




}
