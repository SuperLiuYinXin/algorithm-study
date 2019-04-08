package com.liuyinxin;

import com.liuyinxin.tree.Solution;
import com.liuyinxin.tree.TreeNode;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        long a = 1, b = 1, c = 100007, r = 0;

        for (int i = 3 ; i <= 100000; ++i) {
            r = (a + b) % c;
            a = b;
            b = r;
        }
        System.out.println(r);

    }
}
