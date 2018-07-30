package com.liuyinxin.list;

public class 合并两个有序链表 {

    public static void main(String[] args) {
        合并两个有序链表  s = new 合并两个有序链表 ();

//        ListNode l1 = new ListNode(1);

        ListNode l1 = new ListNode(1);
//
        ListNode l2 = new ListNode(2);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(4);
//
//        ListNode l2 = new ListNode(1);
//
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);


        ListNode l3 =  s.mergeTwoLists(l1, l2);

        while (l3 != null){
            System.out.println(
                    l3.val
            );
            l3 = l3.next;
        }

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null ){
            return l2;
        } else if (l2 == null){
            return l1;
        }

        ListNode head = new ListNode(0);

        ListNode cur = head;
        while (l1 !=null && l2 != null){
            if (l1.val < l2.val){ // 左边小
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 如果l1还不为空
        while (l1 !=null){
            cur.next = new ListNode(l1.val);
            cur = cur.next;
            l1 = l1.next;
        }

        while (l2 != null){
            cur.next = new ListNode(l2.val);
            cur = cur.next;
            l2 = l2.next;
        }
        head = head.next;
        return head;
    }

}
