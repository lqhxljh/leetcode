package com.lqhx.leetcode;


public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean isValid = solution.isValid("([)]");
        ListNode listNode1 = new ListNode(2);

        ListNode listNode3 = new ListNode(1);

        solution.mergeTwoLists(listNode1, listNode3);
        System.out.println(isValid);
    }
}
