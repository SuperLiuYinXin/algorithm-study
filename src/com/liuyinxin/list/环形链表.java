package com.liuyinxin.list;

/**
 * 给定一个链表，判断链表中是否有环。
 进阶：
 你能否不使用额外空间解决此题？
 */
public class 环形链表 {

    public static void main(String[] args) {
        环形链表  s = new 环形链表 ();
        ListNode l = new ListNode(1);
        l.next  = new ListNode(2);
        l.next.next = new ListNode(3);
        System.out.println(
                s.hasCycle(l)
        );
    }

    /**
     * 思路，快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) return false;

        ListNode pre = head;
        ListNode cur = head;

        while (pre != null && pre.next != null && pre.next.next != null){
            cur = cur.next;
            pre = pre.next.next;
            if (pre == cur){
                return true;
            }
        }
        return false;
    }

}
