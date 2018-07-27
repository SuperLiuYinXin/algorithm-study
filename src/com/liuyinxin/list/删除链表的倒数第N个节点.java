package com.liuyinxin.list;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

 示例：

 给定一个链表: 1->2->3->4->5, 和 n = 2.

 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 说明：

 给定的 n 保证是有效的。

 进阶：

 你能尝试使用一趟扫描实现吗？
 */
public class 删除链表的倒数第N个节点 {

    public static void main(String[] args) {

        删除链表的倒数第N个节点 s = new 删除链表的倒数第N个节点();

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
        listNode =  s.removeNthFromEnd(listNode, 2);

        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode next = head, pre = null;

        int len = 0;

        while (next!= null){
            ++len;
            next = next.next;
        }

        // 如果是非法值，删除// 或者只有一个
        if (len <= 1){
            return null;
        }

        int obj = len - n;

        next = head;
        while (obj-- > 0){
            pre = next;
            next = next.next;
        }

        // 如果是最后一个
        if (next.next == null && pre != null){
            pre.next = null;
        } else {
            next.val = next.next.val;
            next.next =  next.next.next;
        }

        return head;
    }
}
