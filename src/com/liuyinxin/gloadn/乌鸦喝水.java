package com.liuyinxin.gloadn;

import java.util.Scanner;

/**
 * 乌鸦喝水：第一次1杯，第二次1/2杯，第三次1/4杯···
 * 每次喝的水都是前一次的一半，如果乌鸦一共喝了n次，计算乌鸦一共喝了多少水，结果用分数表示出来。
 * 编程实现计算过程，语言不限。
 * 例如：输入n=2，输出为3/2。
 * 注意：输出结果要求分子和分母互质
 * @author: liuyinxin-896400010@qq.com
 * @date: 2019-03-19
 * @time: 19:06
 * do the best
 */
public class 乌鸦喝水 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        if(n <= 0) { System.out.println(0); return; }
        long z = 1, m = 1, r;
        n--;
        while (n -- > 0) {
            z = (z << 1) +1;
            m = m << 1;
        }
        System.out.println(z + "/" + m);
    }
}
