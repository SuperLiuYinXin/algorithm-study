package com.liuyinxin.other;

public class 颠倒二进制位_190 {

    public static void main(String[] args) {
        颠倒二进制位_190 s = new 颠倒二进制位_190 ();

        System.out.println(
                s.reverseBits(43261596)
        );

    }

    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 31; i >= 0; --i){
            ans =  ans | (n >>> (31 - i) & 1) << i;
        }
        return ans;
    }
}
