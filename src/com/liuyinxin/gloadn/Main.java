package com.liuyinxin.gloadn;

import java.util.Scanner;

/**
 * @author: liuyinxin-896400010@qq.com
 * @date: 2019-04-19
 * @time: 20:19
 * do the best
 */
public class Main {

    static int[][] arr = null;
    static boolean[][] visit = null;
    static int[] V;
    static int rate;

    public static int dp(int i, int pos) {
        if (i  - 1 < 0) return 0;
        if (visit[i][pos]) return arr[i][pos];

        visit[i][pos] = true;
        // 前一个买入
        if (pos == 1) {
            arr[i][1] = Math.max(
                    dp(i - 1, 0) - V[i - 1] ,
                    dp(i - 1, 1));
        } else if (pos == 0) {
            arr[i][0] = Math.max(
                    dp(i -1, 0), V[i - 1] + dp(i - 1, 1) - rate
            );
        }
        return arr[i][pos];
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Scanner nin = null;
        String str = in.nextLine();
        int pl, pr, pos = 0;
        pl = str.indexOf('['); pr = str.indexOf(']');
        nin = new Scanner(str.substring(pr + 2));
        while (nin.hasNext()) {
            try {
                pos = nin.nextInt();
                break;
            } catch (Exception e) {
                nin.next();
                continue;
            }
        }
        nin.close();
        in.close();
        rate = pos;
        String[] splitArr = str.substring(pl + 1, pr).split(",");
        V = new int[splitArr.length];
        for (int i = 0; i < splitArr.length; ++i){
            V[i] = Integer.parseInt(splitArr[i]);
        }
        arr = new int[V.length + 1][2];
        visit = new boolean[V.length + 1][2];
        System.out.println( Math.max(dp(V.length - 2, 0),dp(V.length-2, 1)));
    }
}
