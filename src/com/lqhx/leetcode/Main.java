package com.lqhx.leetcode;


import com.lqhx.leetcode.DataStruck.ListNode;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.toString());
        int result =  solution.myAtoi("42");
        System.out.println( solution.countAndSay(5));
        ListNode temp1 = new ListNode(-129);
        ListNode temp2 = new ListNode(-129);
        temp1.next = temp2;
        System.out.println(solution.isPalindrome(temp1));
        System.out.println(solution.firstBadVersion(3));
    }
}
