package com.liuyinxin.leetcode;

import java.util.*;

/**
 * @TODO  timeout, need optimization
 * @Author: liuyinxin
 * @Date: 2019-04-14
 * @Time: 14:57
 * do the best
 */
public class Solution {


    public Edge getMin(List<List<Edge>> map) {
        Edge minE = null,  e;
        for (int i = 0; i < map.size(); ++i) {
            if (vw[i]) continue;
            List<Edge> l = map.get(i);
            for (int j = 0; j < l.size(); ++j) {
                e = l.get(j);
                if (vb[e.t]) continue;
                if (minE == null)
                    minE = e;
                else {
                    if (e.l == minE.l) {
                        if (e.f < minE.f) {
                            minE = e;
                        } else {
                            if (e.t < minE.t) {
                                minE = e;
                            }
                        }
                    } else if (e.l < minE.l) {
                        minE = e;
                    }
                }
            }
        }
        if (minE != null) { vw[minE.f] = true; vb[minE.t] = true; }
        return minE;
    }

    public static int dis(int x, int y, int x1, int y1) {
        return Math.abs(x1 - x) + Math.abs(y1 - y);
    }

    public static class Edge {
        int f; int t; int l;
        public Edge(int f, int t,int l) { this.f = f; this.t = t; this.l = l; }
    }

    public boolean[] vw;
    public boolean[] vb;

    public int[] getMin(int[][] map, int w, int b) {
        LinkedList<Edge> l = new LinkedList<>();
        Edge minE = null;
        for (int i = 0; i < w; ++i) {
            if (vw[i]) continue;
            for (int j = 0; j < b; ++j) {
                if (vb[j]) continue;
                if (minE == null)
                    minE = new Edge(i, j, map[i][j]);
                else {
                    if (map[i][j] == minE.l) {
                        if (i < minE.f) {
                            minE = new Edge(i, j, map[i][j]);
                            l.addFirst(minE);
                        } else {
                            if (j < minE.t) {
                                minE = new Edge(i, j, map[i][j]);
                                l.addFirst(minE);
                            }
                        }
                    } else if (map[i][j] < minE.l) {
                        minE = new Edge(i, j, map[i][j]);
                        l.addFirst(minE);
                    }
                }
            }
        }
        int[] arr = new int[w];
        for (int i = 0; i < w && l.getFirst() != null; ++i) {
            minE = l.getFirst();
            if (!vw[minE.f] && !vb[minE.t]) {
                 vw[minE.f] = true; vb[minE.t] = true;
                 arr[minE.f] = minE.t ;
            }
            l.removeFirst();
        }
        return arr;
    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int w = workers.length;
        int b = bikes.length;
        vw = new boolean[w];
        vb = new boolean[b];
        int[][] map = new int[w][b];
        for (int i = 0; i < w; ++i) {
            for (int j = 0; j < b; ++j) {
                map[i][j] = dis(workers[i][0], workers[i][1], bikes[j][0], bikes[j][1]);
            }
        }
        int[] ans  = getMin(map, w, b);
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] w = {{0, 0}, {1, 1}, {2, 0}};
        int[][] b = {{1, 0}, {2, 2}, {2, 1}};

        int[][] w1 = {{0, 0}, {2, 1}};
        int[][] b1 = {{1, 2}, {3, 3}};
//        System.out.println(Arrays.toString(s.assignBikes(w, b)));
        System.out.println(Arrays.toString(s.assignBikes(w1, b1)));
    }


}
