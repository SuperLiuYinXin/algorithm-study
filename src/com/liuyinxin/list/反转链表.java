package com.liuyinxin.list;

public class 反转链表 {

    public static void main(String[] args) {
        反转链表 s = new 反转链表();
        ListNode l = new ListNode(1);
        l.next  = new ListNode(2);
        l.next.next  = new ListNode(3);
        System.out.println(
                s.reverseList(l).val
        );
    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;


        ListNode cur = head, pre = null, tmp;
        while (cur != null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
