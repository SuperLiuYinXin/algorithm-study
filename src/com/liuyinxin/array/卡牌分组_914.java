package com.liuyinxin.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 卡牌分组_914 {

    public static void main(String[] args) {
        卡牌分组_914 s = new 卡牌分组_914 ();

        int[] nums = {
                1,2,3,4,4,3,2,1
        };


        System.out.println(
                s.hasGroupsSizeX(nums)
        );

        int[] nums1 = {1,1};
        System.out.println(
                s.hasGroupsSizeX(nums1)
        );
        int[] nums2 = {1,1, 2, 2,2,2};
        System.out.println(
                s.hasGroupsSizeX(nums2)
        );
        int[] nums3 = {0,0,0, 1,1, 1, 2,2,2};
        System.out.println(
                s.hasGroupsSizeX(nums3)
        );
        int[] nums4 = {1,1,1,1,2,2,2,2,2,2};
        System.out.println(
                s.hasGroupsSizeX(nums4)
        );
        int[] nums5 = {};
        System.out.println(
                s.hasGroupsSizeX(nums5)
        );
    }


    public boolean hasGroupsSizeX(int[] deck) {

        int maxn = 10000 + 5;

        int[] counts = new int[maxn];

        for (int d: deck){
            counts[d]++;
        }
        int g = 0;

        for (int d: deck){

            g = gcd(g, counts[d]);
        }

        return g != 1 && g != 0;
    }

    public static int gcd(int a, int b) {

        while (b > 0) {
            int c = a;
            a = b;
            b = c % a;
        }
        return a;
    }
}
