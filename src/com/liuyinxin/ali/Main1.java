package com.liuyinxin.ali;

/**
 * @Author: liuyinxin
 * @Date: 2019-04-12
 * @Time: 19:47
 * do the best
 */

import java.util.*;

public class Main1 {

    public static Comparator<Pig> cm = (o1, o2) -> o2.id - o1.id;
    /**
     *
     * 小明是一个数学家，他喜欢用数字给事物命名编号，他给自己编号为1，同时在2019年小明开办了一个农场，
     * 准备开始养母猪，他专门给农场的母猪用以下数列2，3，4，5，7，9，12，16，21，28，37，49，65，86，114，151...进行命名。假设农场的母猪
     * 永远不会死，小母猪出生后3年后成熟，成熟后从第三年开始每年只会生一只小母猪。
     * 第一年农场，有一只刚刚出生的小母猪和一只成熟的母猪(本年不再生小猪，下一年开始生小猪)，
     * 并给他们编号为2和3。请问，第m只母猪编号为多少？其是哪一年出生的？
     * 小明还准备了1份礼物，专门颁给农场第1到m只的母猪颁奖，
     * 颁奖规则如下:选出第1到m只的母猪翻转编号(114编号翻转为411)为第k大的母猪进行颁奖，
     * 请问是第几只猪获奖？提示: f(n)=f(n-2)+f(n-3)
     */

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static class Pig implements Comparable{
//        int year;
        int id;
        public Pig(int year, int id) {
//            this.year = year;
            this.id = id;
        }

        @Override
        public int compareTo(Object o) {
            return ((Pig)o).id - this.id;
        }
    }

    static public int reverse(int n) {
        int r = 0;
        while (n > 0) {
            r *= 10;
            r  += + n % 10;
            n /= 10;
        }
        return r;
    }

    static String calculate(int m, int k) {
        int []year = {1, 0, 0, 1, 0, 1, 1};
        int start = 2019;
        int cur = 3, id;
        List<Pig> l = new ArrayList<>(m + 1);
        l.add(new Pig(start, 2));
        l.add(new Pig(start, 3));
        if (m > 2)
            l.add(new Pig(start, 4));
        int[] arr = new int[m + 1];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;

        while (cur < m) {
            start++;
            year[3] += year[2];
            year[2] = year[1];
            year[1] = year[0];
            year[0] = year[3];
            for (int i = 0; i < year[3] && cur < m; ++i) {
                cur += 1;
                arr[cur] = arr[cur -2] + arr[cur -3];
                l.add(new Pig(start,arr[cur]));
            }
        }
        for (Pig pig: l) {
            pig.id = reverse(pig.id);
        }

        PriorityQueue<Pig> pigs = new PriorityQueue<Pig>(l);

        Pig pig = null;
        for (int i = 0; i < k; ++i) {
            pig = pigs.poll();
        }

        String rtn = arr[m] + " " + (start - 1) + " " + reverse(pig.id);
        return rtn;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);;
        System.out.println(calculate(m, k));

    }
}
