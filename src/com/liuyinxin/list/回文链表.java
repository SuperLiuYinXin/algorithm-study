package com.liuyinxin.list;

public class 回文链表 {

    public static void main(String[] args) {

        回文链表  s = new  回文链表 ();
        ListNode l = new ListNode(1);
//        l.next  = new ListNode(1);
//        l.next  = new ListNode(2);
//        l.next.next  = new ListNode(1);
        System.out.println(
                s.isPalindrome(l)
        );
    }

    // 思路，快慢指针
    // 快指针走到头的时候，慢指针刚好到中间
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = reverse(slow);

        while (slow != null && head != null){
            if (head.val != slow.val){
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    ListNode reverse(ListNode listNode) {
        if (listNode == null || listNode.next == null){
            return listNode;
        }

        ListNode pre = null, tmp,cur = listNode;
        while (cur != null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
