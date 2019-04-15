package com.liuyinxin.bd;

import java.util.*;

/**
 * 变身程序员
 * @Author: liuyinxin
 * @Date: 2019-04-14
 * @Time: 10:02
 * do the best
 */
public class Main1 {

    public static int change = 0, time = 0;

    public static boolean [][] visit;

    public static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static class P {
        int x; int y;
        public P (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int change(int[][] map, int x, int y, int h, int w) {
        int t = 0 ;
        Queue<P> q = new LinkedList<>();
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                if (!visit[i][j] && map[i][j] == 2) {
                    q.add(new P(i, j));
                    visit[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            P point = q.poll();
            for (int[] ints : d) {
                int nx = point.x + ints[0], ny = point.y + ints[1];
                if (nx >= 0 && ny >= 0 && nx < h && ny < w
                        && !visit[nx][ny] && map[nx][ny] == 1) {
                    map[nx][ny] = 2;
                    ++t;
                }
            }
        }
        return t;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> l = new ArrayList<>();
//        int t = 0;
//        while (in.hasNext() && t++ < 3) {
        while (in.hasNextLine()) {
            l.add(in.nextLine());
        }
        int w = l.get(0).split(" ").length;
        int[][] map = new int[l.size()][w];
        int expire = 0;
        visit = new boolean[l.size()][w];
        for (int i = 0; i < l.size(); ++i) {
            String[] split = l.get(i).split(" ");
            for (int j = 0; j < w; ++j) {
                map[i][j] = Integer.parseInt(split[j]);
                if (map[i][j] == 1)
                    expire++;
            }
        }
        int total = 0, cur;
        for (int i = 0; i < l.size(); ++i) {
            for (int j = 0; j < l.size(); ++j) {
                if (map[i][j] == 2 && !visit[i][j]) {
                    cur = change(map, i, j, l.size(), w);
                    if (cur > 0) {
                        total+= cur;
                        time++;
                    }
                }
            }
        }
        if (expire == total) {
            System.out.println(time);
        } else  {
            System.out.println(-1);
        }
    }

}
