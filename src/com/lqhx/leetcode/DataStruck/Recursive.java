package com.lqhx.leetcode.DataStruck;


public class Recursive {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode result = new ListNode(head.val);
            ListNode node = head.next;
            while (node != null) {
                ListNode nodeTemp = new ListNode(node.val);
                nodeTemp.next = result;
                result = nodeTemp;
                node = node.next;
            }
            return result;

        }

    }

    public ListNode reverseRecursiveList(ListNode head)  {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode result = new ListNode(head.val);
            ListNode node = head.next;
            result =reverseRecursiveList(node, result);
            return result;
        }
    }



    public ListNode reverseRecursiveList(ListNode node, ListNode result) {
        if (node != null) {
            ListNode nodeTemp = new ListNode(node.val);
            nodeTemp.next = result;
            result = nodeTemp;
            node = node.next;
            result = reverseRecursiveList(node,result);
        }
        return result;
    }
}
