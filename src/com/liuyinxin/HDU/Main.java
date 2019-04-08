package com.liuyinxin.HDU;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static int debug = 1;
    public static InputStream is = System.in;

    static {
        if (debug == 1)
            try {
                is = new FileInputStream(new File("/home/liuyinxin/code/java/algorithm-study/src/com/liuyinxin/HDU/in.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
    }

    static int seq[] = new int[1005];

    public static int find(int a) {
        int r = a;
        while (seq[r] != r) {
            r = seq[r];
        }
        int i = a, j;
        // 路径压缩算法
        while (seq[i] != r) {
            j = seq[i];
            seq[i] = r;
            i = j;
        }
        return r;
    }

    public static void mix(int a, int b) {
        int i = find(a), j = find(b);
        if (i != j) {
            // j的前一个节点是ｉ
            seq[j] = i;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(is);

        int m, n, ans, i;
        int maxn = 1005;
        int p[] = new int[maxn];
        while ( (n = in.nextInt()) > 0) {
            m = in.nextInt();
            for (i = 1; i <= n; ++i) {
                p[i] = 0;
                seq[i] = i;
            }
            for (i = 0; i < m; ++i) {
                int a = in.nextInt(), b = in.nextInt();
                mix(a, b);
            }
            for (i = 1; i <= n; ++i){
                p[find(i)] = 1;
            }

            for (i = 1, ans = 0; i <= n; ++i) {
                if (p[i] == 1)
                    ++ans;
            }
            System.out.println(ans - 1);
        }
    }
}
