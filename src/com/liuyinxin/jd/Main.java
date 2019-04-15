package com.liuyinxin.jd;


import com.liuyinxin.tree.TreeNode;

import java.util.*;

/**
 *
 * 题目描述：
 * 体育场突然着火了，现场需要紧急疏散，但是过道真的是太窄了，同时只能容许一个人通过。现在知道了体育场的所有座位分布，座位分布图是一棵树，已知每个座位上都坐了一个人，安全出口在树的根部，也就是1号结点的位置上。其他节点上的人每秒都能向树根部前进一个结点，但是除了安全出口以外，没有任何一个结点可以同时容纳两个及以上的人，这就需要一种策略，来使得人群尽快疏散，问在采取最优策略的情况下，体育场最快可以在多长时间内疏散完成。
 * 最小生成树
 * @Author: liuyinxin
 * @Date: 2019-04-13
 * @Time: 19:41
 * do the best
 */
public class Main {

    public static class Tree {
        HashMap<Integer, Tree> leafs;
        int v;
        public Tree(int v) {
            leafs = new HashMap<>();
            this.v = v;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int u = 0, v = 0;
        int[] tree = new int[n + 1];

        for (int i = 1; i < n; ++i) {
            u = in.nextInt();
            v = in.nextInt();
            tree[u] = v;
        }

        Tree r = new Tree(0);
        Tree curR, preR;
        for (int i = 2; i <= n; ++i) {
            curR = preR = r;
            int p = tree[i];
            Stack<Integer> s = new Stack<>();
            s.push(i);
            while (p != 1) {
                s.push(p);
                p = tree[p];
            }
            while ( !s.isEmpty()) {
                p = s.pop();
                preR = curR.leafs.get(p);
                if (preR == null) {
                    preR = new Tree(p);
                    curR.leafs.put(p , preR);
                }
                curR = preR;
            }
        }
        count = 1;
        // 删除边
        int ans = 0;
        Queue<Tree> q = new LinkedList<>();
        Queue<Tree> level = new LinkedList<>();
        q.add(r);
        boolean first = true;
        while (!q.isEmpty()) {
            for (Map.Entry<Integer, Tree> e:  q.poll().leafs.entrySet()) {
                if (!first) System.out.print(' '); else first = false;
                System.out.print(e.getKey());
                level.add(e.getValue());
            }
            if (q.isEmpty() && !level.isEmpty()) {
                q = level;
                first = true;
                level = new LinkedList<>();
                System.out.println();
            }
        }





//        while (count < n) {
//            HashMap<Integer, Tree> t = r.leafs;
//            ++ans;
//            for (Map.Entry<Integer, Tree> e:  t.entrySet()) {
//                delete(e.getValue(),r);
//            }
//        }
        System.out.println(ans);
    }

    static int count;

    public static boolean delete(Tree node, Tree parent) {
        if (node.leafs.size() ==  0) {
            parent.leafs.remove(node.v);
            count++;
            return true;
        } else {
            HashMap<Integer, Tree> t = node.leafs;
            for (Map.Entry<Integer, Tree> e:  t.entrySet()) {
                if (delete(e.getValue(), node)) {
                    return true;
                }
            }
        }
        return false;
    }
}
