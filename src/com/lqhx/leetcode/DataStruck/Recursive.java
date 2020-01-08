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

    public ListNode reverseRecursiveList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode result = new ListNode(head.val);
            ListNode node = head.next;
            result = reverseRecursiveList(node, result);
            return result;
        }
    }


    public ListNode reverseRecursiveList(ListNode node, ListNode result) {
        if (node != null) {
            ListNode nodeTemp = new ListNode(node.val);
            nodeTemp.next = result;
            result = nodeTemp;
            node = node.next;
            result = reverseRecursiveList(node, result);
        }
        return result;
    }

    public int maxDepth(TreeNode root) {
        int result = 0;
        result = getDepth(root);
        return result;
    }

    private int getDepth(TreeNode root) {
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthGrammar(int N, int K) {
        StringBuffer[] results = new StringBuffer[N + 1];
        for (int i = 0; i <= N; i++) {
            if (i == 0) {
                results[0] = new StringBuffer("0");
            } else {
                StringBuffer temp = results[i - 1];
                StringBuffer temp2 = new StringBuffer("");
                for (int j = 0; j < temp.length(); j++) {
                    char tempChar = temp.charAt(j);
                    if (tempChar == '0') {
                        temp2.append("01");
                    } else {
                        temp2.append("10");
                    }
                }
                results[i] = temp2;
            }
        }
        if (K <= results[N].length()) {
            return results[N].charAt(K) - '0';
        } else {
            return 0;
        }
    }
}
