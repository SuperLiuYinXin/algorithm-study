package com.liuyinxin.other;

/**
 * 又称为汉明重量
 */
public class 位1的个数_191 {

    public static void main(String[] args) {

        位1的个数_191 s = new 位1的个数_191();

        System.out.println(
            s.hammingWeight(7)
        );
    }

    public int hammingWeight(int n) {
        int ans = 0;
        for (;n != 0; n = n & (n-1)) ans++;
        return ans;
    }

}
