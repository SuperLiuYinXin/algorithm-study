package com.liuyinxin.list;

public class 删除链表中的节点 {

    public static void main(String[] args) {
        删除链表中的节点 s = new 删除链表中的节点();
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(9);
        s.deleteNode(listNode.next.next);

        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
