package com.lqhx.leetcode;

import com.lqhx.leetcode.datastruck.ListNode;

public class RecursiveSolution {
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


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 第K个语法符号
     * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
     * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
     */
    public int kthGrammar(int N, int K) {
        if (N < 1 || K > Math.pow(2, N - 1) || K < 1) {
            return 0;
        } else {
            if (N == 1 || K == 1) {
                return 0;
            } else {
                int result = kthGrammar(N - 1, (K + 1) / 2);
                if (K % 2 == 1) {
                    return result;

                } else {
                    if (result == 0) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        }
    }

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        } else if (n > 0) {
            return pow(x, n);
        } else if (n == 0) {
            return 1;
        } else {
            return 1 / pow(x, -n);
        }
    }

    private double pow(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * (pow(x, n - 1));
        }
    }




}
