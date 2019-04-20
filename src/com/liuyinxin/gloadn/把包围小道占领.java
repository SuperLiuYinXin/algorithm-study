package com.liuyinxin.gloadn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: liuyinxin-896400010@qq.com
 * @date: 2019-04-19
 * @time: 19:15
 * do the best
 */
public class 把包围小道占领 {

    public static int w = 0, h = 0;
    public static boolean visit[][];
    public static char[][] map;
    public static int[][] d = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void dfs(int x, int y) {
        if (visit[x][y]) return;
        visit[x][y] = true;
        int nx, ny;
        map[x][y] = '.';
        for(int i = 0; i < d.length; ++i) {
            nx = x + d[i][0]; ny = y + d[i][1];
            if (nx >= 0 && nx < h && ny >= 0 && ny < w && !visit[nx][ny]
            && map[nx][ny] == 'O') {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        String s = null;
        Scanner in = new Scanner(System.in);
        List<String> l = new ArrayList<>();
//        int c = 0;
        while (in.hasNext()) {
            s = in.nextLine();
            l.add(s);
//            ++c;
//            if (c >= 4) break;;
        }
        if (l.size() <= 0) { System.out.println(); return; }
        else if (l.size() == 1) { System.out.println(l.get(0)); return; }
        h = l.size();
        w = l.get(0).length();
        map = new char[l.size()][w + 1];
        visit = new boolean[h][w];
        for (int i = 0; i < h; ++i) {
            map[i] = l.get(i).toCharArray();
        }

        for (int i = 0; i < w; ++i){
            if (!visit[0][i] && map[0][i] == 'O') {
                dfs(0, i);
            }
            if ( h > 0 &&!visit[h - 1][i] && map[h - 1][i] == 'O') {
                dfs(h - 1, i);
            }
        }
        for (int i = 0; i < h; ++i) {
            if (!visit[i][0] && map[i][0] == 'O') {
                dfs(i, 0);
            }
            if (w > 0 && !visit[h - 1][w - 1] && map[h - 1][w - 1] == 'O') {
                dfs(h -1, w - 1);
            }
        }
        for (int i = 0; i < w; ++i) {
            for (int j = 0; j < h; ++j) {
                if (map[i][j] == '.') {
                    map[i][j] = 'O';
                } else if (map[i][j] == 'O') {
                    map[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < h; ++i) {
            System.out.println(map[i]);
        }
    }
}
