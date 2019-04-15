package com.liuyinxin.bd;

import java.util.Scanner;

/**
 * 机器人跳跃
 * @Author: liuyinxin
 * @Date: 2019-04-14
 * @Time: 10:02
 * do the best
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i){
            arr[i] = in.nextInt();
        }
        int e = arr[n - 1];
        int add = 0;
        for (int i = n - 2; i >= 0; --i) {
            add = e + arr[i];
            e = add / 2;
            if ((add & 1) == 1)
                e+=1;
        }
        System.out.println(e);
    }

}
