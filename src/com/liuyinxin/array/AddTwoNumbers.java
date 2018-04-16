package com.liuyinxin.array;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class AddTwoNumbers {

    public static void main(String[] args){
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(6);

        ListNode l2 = new ListNode(6);
        l2.next = new ListNode(7);
        l2.next.next = new ListNode(8);

        AddTwoNumbers add = new AddTwoNumbers();
        ListNode result = add.addTwoNumbers(l1,l2);
        while (result != null){
            System.out.print(result.val);
            System.out.print(",");
            result = result.next;
        }


    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        int al = 0, bl = 0; // 长度
        for(ListNode temp = l1;temp != null;temp = temp.next, al++);
        for(ListNode temp = l2;temp != null;temp = temp.next, bl++);
        if (al < bl){ // 交换,让al始终为最大得
            ListNode  temp = l1;
            l1 = l2;
            l2 = temp;
            int t = al;
            al = bl;
            bl = t;
        }
        ListNode result = null;
        ListNode curNode = null;
        int isUp = 0;
        for (int i = 0; i < al; i ++){
            int sum = l1.val + isUp;
            l1 = l1.next;
            isUp = 0; // 消除进位
            if (i < bl){
                sum += l2.val;
                l2 = l2.next;
            }
            if (sum > 9){
               isUp = 1;
               sum -= 10;
            }
            if (curNode == null){
                result = new ListNode(sum);
                curNode = result;
            } else {
                curNode.next = new ListNode(sum);
                curNode = curNode.next;
            }
        }
        if (isUp > 0){
            curNode.next = new ListNode(isUp);
        }
        return result;
    }

    public ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        int carry = 0; // 进位
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while (l1 != null || l2 != null || carry > 0){ // 或者有进位
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val: 0) + carry;
            carry = 0;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
            if (sum > 9){
                carry = 1;
                sum -= 10;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
        }
        return result.next;
    }
}
