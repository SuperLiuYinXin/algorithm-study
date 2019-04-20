package com.liuyinxin.gloadn;


import java.util.Scanner;

/**
 * 判断链表是否有环
 * @author: liuyinxin-896400010@qq.com
 * @date: 2019-04-19
 * @time: 19:46
 * do the best
 */
public class 判断链表是否有环 {

    public static int hasCircle(Node node) {
        int ans = -1;
        if (node == null || node.next == null || node.next.next == null) {
            return ans;
        }
        boolean isLoop = false;
        Node lHead = node, fHead = node;
        while (fHead != null) {
            lHead = lHead.next;
            if (fHead.next != null) {
                fHead = fHead.next.next;
            } else break;
            if (lHead == fHead) {
                isLoop = true;
                break;
            }
        }
        if (!isLoop) { return ans; }

        lHead = node;
        ans = 0;
        while (lHead != fHead) {
            ans++;
            lHead = lHead.next;
            fHead = fHead.next;
        }
        return ans;
    }

    public static class Node {
        int v;
        Node next;
        public Node(int v) {this.v = v;};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner nin = null;
        String str = in.nextLine();
        int pl, pr, pos;
        pl = str.indexOf('[');
        pr = str.indexOf(']');
        try {
            nin = new Scanner(str.substring(pr + 2));
            nin.next();
            nin.next();
            pos = nin.nextInt();
        } catch (Exception e){
            System.out.println("no cycle");
            return;
        }
        nin.close();
        in.close();
        String[] splitArr = str.substring(pl + 1, pr).split(",");
        int[] nodeV = new int[splitArr.length];
        for (int i = 0; i < splitArr.length; ++i){
            nodeV[i] = Integer.parseInt(splitArr[i]);
        }
        if (nodeV.length == 0) {
            System.out.println("no cycle");
            return;
        }

        Node head = new Node(-1);
        Node cur = head, circle = null;
        for (int i = 0;i < nodeV.length; ++i){
            cur.next = new Node(nodeV[i]);
            if ( i == pos) {
                circle = cur.next;
            }
            cur = cur.next;
        }
        head = head.next;
        if (circle != null) {
            cur.next = circle;
        }

        Integer ans = null;
        if ( (ans = hasCircle(head)) != -1) {
            System.out.println("tail connects to node index " + ans);
        } else  {
            System.out.println("no cycle");
        }

    }
}
