package com.liuyinxin.graph;

import java.util.Scanner;

/**
 * @Author: liuyinxin
 * @Date: 2019-04-13
 * @Time: 18:15
 * do the best
 */
public class Main {

    public static int INF = Integer.MAX_VALUE >> 1;

    public static void main(String[] args) {
        int u,v;
        Scanner in = new Scanner(System.in);
        while ( (u = in.nextInt()) != 0 && (v = in.nextInt()) != 0) {
            int [][] graph = new int[u][u];
            int[] w = new int[u];
            boolean [] visit = new boolean[u];
            for (int i = 0; i < u; ++i)
                for (int j = 0; j < u; ++j)
                    graph[i][j] = INF;

            for (int i = 0; i < v; ++i) {
                int f = in.nextInt() - 1;
                int t = in.nextInt() - 1;
                graph[f][t] = in.nextInt();
                graph[t][f] = graph[f][t];
            }

            for (int i = 0; i < u; ++i)
                if (graph[0][i] != INF)
                    w[i] = graph[0][i];
                else
                    w[i] = INF;

            for (int i = 0; i < u; ++i) {
                int minI = -1, minV = INF;
                for (int j = 0; j < u; ++j) {
                    if (!visit[j] && w[j] < minV) {
                        minV = w[j];
                        minI = j;
                    }
                }
                visit[minI] = true;
                for (int j = 0; j < u; ++j) {
                    if (!visit[j] && graph[minI][j] != INF && w[j] > w[minI] + graph[minI][j]) {
                        w[j] = w[minI] + graph[minI][j];
                    }
                }
            }
            System.out.println(w[u - 1]);
        }
    }
}
