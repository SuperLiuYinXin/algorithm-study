package com.liuyinxin.bd;

import java.util.*;

/**
 * @Author: liuyinxin
 * @Date: 2019-04-14
 * @Time: 10:02
 * do the best
 */
public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, sum = 0;
        n = in.nextInt();
        int i =  0,j = 0,k;
        int[] visit = new int[n];
        int[][] dist = new int[n][n];
        int INF = Integer.MAX_VALUE >> 1;
        int flag; // v 1 nv 0
        for (i = 0; i < n; ++i) {
            for (j = 0; j < n; ++j) {
                dist[i][j] = in.nextInt();
            }
        }
        for (i = 1; i < n; ++i) {
            k = 1;
            INF = Integer.MAX_VALUE >> 1;
            for (k = 1; k < n; ++k) {
                flag = 0;
                for (int l = 0; l < i; ++l) {
                    if (visit[l] == k) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0 && dist[k][visit[i - 1]] < INF) {
                    j = k;
                    INF = dist[k][visit[i - 1]];
                }
            }
            visit[i] = j;
            sum += INF;
        }
        sum += dist[0][j];
        System.out.println(sum);
    }
}
