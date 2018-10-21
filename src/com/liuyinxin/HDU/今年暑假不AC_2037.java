package com.liuyinxin.HDU;


import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 今年暑假不AC_2037 {

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

    static class tv {
        int start;
        int end;

        @Override
        public String toString() {
            return start + ":" + end;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(is);

        while (in.hasNextInt()) {
            int t = in.nextInt();
            if (t <= 0) break;
            tv[] tvs = new tv[t];
            // 输入完毕
            for (int i = 0; i < t; ++i) {
                tvs[i] = new tv();
                tvs[i].start = in.nextInt();
                tvs[i].end = in.nextInt();
            }

            Arrays.sort(tvs, new Comparator<tv>() {
                @Override
                public int compare(tv o1, tv o2) {
                    int time = o1.end - o2.end;
                    if (time != 0) return time;
                    return o1.start - o2.start;
                }
            });

            int end = tvs[0].end;
            int count = 1;
            for (int i = 1; i < t; ++i) {
                if (tvs[i].start >= end) {
                    end = tvs[i].end;
                    ++count;
                }
            }
            System.out.println(count);
        }
    }
}
