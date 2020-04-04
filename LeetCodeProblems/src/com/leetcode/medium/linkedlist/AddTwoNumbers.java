package com.leetcode.medium.linkedlist;


import com.leetcode.common.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + " --> ");
            result = result.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), result = head;
        int remainder = 0;
        while (l1 != null && l2 != null) {
            int temp = l1.val + l2.val;
            if (remainder > 0) {
                temp = temp + remainder;
            }
            int sum = temp;
            if (temp > 9) {
                remainder = 1;
                sum = sum % 10;
            } else {
                remainder = 0;
            }
            result.next = new ListNode(sum);
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (remainder > 0) {
            result.next = new ListNode(remainder);
        }
        return head.next;
    }
}
