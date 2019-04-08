package com.liuyinxin.HDU;

import java.io.*;
import java.util.Scanner;

public class Rectangles_2056 {

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

    public static class Rect {
        double x1, x2, y1, y2;

        public Rect(double x1, double y1, double x2, double y2) {
            this.x1 = x1; this.y1 = y1;
            this.x2 = x2; this.y2 = y2;
        }
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(is);
        Rect a , b;
        while (in.hasNext()) {
            a = new Rect(in.nextDouble(), in.nextDouble(), in.nextDouble(), in.nextDouble());
            b = new Rect(in.nextDouble(), in.nextDouble(), in.nextDouble(), in.nextDouble());
            double result = 0;
            result = Math.abs(union(a.x1, a.x2, b.x1, b.x2) * union(a.y1, a.y2, b.y1, b.y2));
            System.out.println(String.format("%.2f", result));
        }
    }

    public static double union (double a, double b, double c, double d) {
        if (b<= c|| d <= a) return 0;
        double r = 0;

        if (a >= c && b <= d)
            r = b - a;
        else if (c >= a && b >= d)
            r = d - c;
        else if  (d > a && a > c)
            r = d - a ;
        else
            r = b - c;
        return Math.abs(r);
    }

}
