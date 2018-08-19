package com.liuyinxin;

import sun.plugin.javascript.navig.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
 *
 * 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 *
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 *
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 */
public class 公平的糖果交换_888 {

    public static void main(String[] args) {
        公平的糖果交换_888 s = new 公平的糖果交换_888();
        int[] a = {1,2,5};
        int[] b = {2,4};
        System.out.println(
                Arrays.toString(s.fairCandySwap(a, b))
        );

    }

    public int[] fairCandySwap(int[] A, int[] B) {
        if (A.length < B.length){
            int [] arr = fairCandySwap(B, A);
            return new int[]{arr[1], arr[0]};
        }

        int aLen = A.length - 1, bLen = B.length - 1;
        int aSum = 0, bSum = 0;

        aSum = sum(A);
        bSum = sum(B);
//        int avg = aSum + Math.abs(bSum - aSum) / 2;
        int avg = (aSum + bSum ) / 2;

        Map<Integer, Integer> aMap = new HashMap<>(A.length);
        for (int i = 0; i <= aLen; ++i){
            aMap.put(A[i], i);
        }

        int obj;
        for (int i = 0 ; i <= bLen; ++i){
            obj = avg - Math.abs(bSum - B[i]);
            if (aMap.containsKey(obj)){
                return new int[]{A[aMap.get(obj)], B[i]};
            }
        }

        return new int[]{0,0};
    }

    public int sum(int[] A){
        int sum = 0;
        for (int i = 0; i < A.length; ++i){
            sum += A[i];
        }
        return sum;
    }



}
