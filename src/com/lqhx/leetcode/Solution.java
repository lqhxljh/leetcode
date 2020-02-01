package com.lqhx.leetcode;

import com.lqhx.leetcode.DataStruck.ListNode;
import com.lqhx.leetcode.DataStruck.TreeNode;

import java.util.*;

public class Solution {
    //leetcode 002
    public int lengthOfLongestSubstring(String strs) {
        if (strs == null || strs.length() == 0) {
            return 0;
        } else if (strs.length() == 1) {
            return 1;
        } else {
            int result = 0;
            ArrayList<Character> characterList = new ArrayList<>();
            for (int i = 0; i < strs.length(); i++) {
                Character character = strs.charAt(i);
                if (characterList.contains(character)) {
                    while (!characterList.isEmpty()) {
                        Character character1 = characterList.get(0);
                        if (character.equals(character1)) {
                            characterList.remove(0);
                            result = Math.max(result, characterList.size());
                            break;
                        } else {
                            characterList.remove(0);
                        }
                    }

                }
                characterList.add(character);
                result = Math.max(result, characterList.size());
            }
            return result;
        }
    }

    /**
     * leetcode 007
     *
     * @param
     * @return
     */
    public int reverse(int x) {
        long result = 0;
        if (x >= 0) {
            String s = String.valueOf(x);
            result = Long.parseLong(reverseString(s));
            if (result > Integer.MAX_VALUE) {
                return 0;
            } else {
                return (int) result;
            }

        } else {
            String s = String.valueOf(x);
            s = s.substring(1);
            result = 0 - Long.parseLong(reverseString(s));
            if (result < Integer.MIN_VALUE) {
                return 0;
            } else {
                return (int) result;
            }
        }
    }

    public String reverseString(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            String xx = String.valueOf(str.charAt(i));
            result += String.valueOf(str.charAt(i));

        }
        return result;
    }

    /**
     * leetcode 015p
     *
     * @param
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        if (nums == null || nums.length <= 2) {
            return result;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        int max = Math.max(Math.max(nums[i], nums[j]), nums[k]);
                        int min = Math.min(Math.min(nums[i], nums[j]), nums[k]);
                        String content = max + "," + min;
                        if (!hashSet.contains(content)) {
                            List<Integer> rightNus = new ArrayList<>();
                            rightNus.add(nums[i]);
                            rightNus.add(nums[j]);
                            rightNus.add(nums[k]);
                            result.add(rightNus);
                            hashSet.add(content);
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * @param guess  2 2 3
     * @param answer 3,2,1
     * @return
     */
    public int game(int[] guess, int[] answer) {
        if (guess == null || answer == null) {
            return 0;
        }
        int dex = 0;
        int result = 0;
        while (dex < guess.length && dex < answer.length) {
            if (guess[dex] == answer[dex]) {
                result++;
            }
            dex++;
        }
        return result;
    }

    public int numJewelsInStones(String J, String S) {
        int result = 0;
        if (S == null || J == null || S.length() == 0 || J.length() == 0 || S.length() < J.length()) {
            return 0;
        } else {
            int length = S.length();
            for (int i = 0; i < J.length(); i++) {
                char replace = J.charAt(i);
                S = S.replace(String.valueOf(replace), "");
            }
            return length - S.length();
        }
    }

    public int singleNumber(int[] nums) {
        if (nums.length == 0) {
            throw new RuntimeException("nums is null");
        }

        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            Integer count = hashMap.get(num);
            if (count == null) {
                count = 0;
            }
            if ((count + 1) > nums.length / 2) {
                return num;
            } else {
                hashMap.put(num, count + 1);
            }
        }
        return 0;
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else {
            int result = 0;
            for (int num : nums) {
                if (num >= target) {
                    return result;
                } else {
                    result++;
                }
            }
            return result;
        }

    }

    /**
     * leet code 66 加1
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头
     */
    public int[] plusOne(int[] digits) {
        if (digits == null) {
            return null;
        } else {
            int mask = 0;
            for (int i = digits.length - 1; i >= 0; i--) {
                if (i == digits.length - 1) {
                    digits[i]++;
                    if (digits[i] >= 10) {
                        mask = 1;
                        digits[i] = 0;
                    } else {
                        mask = 0;
                    }
                } else {
                    digits[i] += mask;
                    if (digits[i] >= 10) {
                        mask = 1;
                        digits[i] = 0;

                    } else {
                        mask = 0;
                    }
                }
            }
            if (mask == 0) {
                int result[] = new int[digits.length + 1];
                result[0] = 1;
                System.arraycopy(digits, 0, result, 1, digits.length);
                return result;
            }
            return digits;
        }
    }

    /**
     * leetcode 09
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * @param x 输入
     * @return 结果
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            int temp = x;
            int result = 0;
            while (temp > 0) {
                result = result + temp % 10;
                temp /= 10;
                if (temp > 0) {
                    result *= 10;
                }
            }
            if (result == x) {
                return true;
            } else {
                return false;
            }
        }

    }

    /**
     * leetcode 09
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     * <p>
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于
     * 大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        String temp = "";
        int doubleResult = 0;
        int index = 0;
        for (index = 0; index < s.length() - 1; ) {
            temp = s.substring(index, index + 2);
            doubleResult = getDoubleRomanNum(temp);
            if (doubleResult == 0) {
                temp = s.substring(index, index + 1);
                result += getRomanNum(temp);
                index++;
            } else {
                result += doubleResult;
                index += 2;
            }
        }
        if (index < s.length()) {
            temp = s.substring(s.length() - 1, s.length());
            return result + getRomanNum(temp);
        } else {
            return result;
        }
    }

    public int getRomanNum(String romanStr) {
        switch (romanStr) {
            case "I":
                return 1;
            case "V":
                return 5;
            case "X":
                return 10;
            case "L":
                return 50;
            case "C":
                return 100;
            case "D":
                return 500;
            case "M":
                return 1000;
            default:
                return 0;

        }
    }

    public int getDoubleRomanNum(String romanStr) {
        switch (romanStr) {

            case "IV":
                return 4;
            case "IX":
                return 9;
            case "IL":
                return 49;
            case "IC":
                return 99;
            case "ID":
                return 499;
            case "IM":
                return 999;
            default:
                return 0;
        }
    }

//    /**
//     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//     * <p>
//     * 有效字符串需满足：
//     * <p>
//     * <p>
//     * 左括号必须用相同类型的右括号闭合。
//     * 左括号必须以正确的顺序闭合。
//     * <p>
//     * <p>
//     * 注意空字符串可被认为是有效字符串。
//     */
//
//    public boolean isValid(String s) {
//        if (s == null || s.length() == 0 || s.length() % 2 == 1) {
//            return false;
//        } else {
//            int max = 0;
//            int mid = 0;
//            int min = 0;
//            for (int i = 0; i < s.length(); i++) {
//                switch (s.)
//            }
//        }
//    }

    /**
     * 21. 合并两个有序链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        insert(l1, l2);
        return l1;
    }

    private void insert(ListNode l1, ListNode l2) {
        if (l2 == null || l1 == null) {
            return;
        } else {
            if (l1.val <= l2.val) {
                if (l1.next == null) {
                    l1.next = l2;
                    return;
                } else if (l1.next.val >= l2.val) {
                    ListNode temp1 = l1.next;
                    ListNode temp2 = l2.next;
                    l1.next = l2;
                    l2.next = temp1;
                    insert(l1.next, temp2);
                } else {
                    insert(l1.next, l2);
                }
            } else {
                ListNode node = new ListNode(l1.val);
                node.next = l1.next;
                l1.val = l2.val;
                l1.next = node;
                insert(l1, l2.next);
            }
        }
    }

//    验证回文字符串
//    给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
//    说明：本题中，我们将空字符串定义为有效的回文串。

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        } else if (s.length() == 0 || s.length() == 1) {
            return true;
        } else {
            int start = 0;
            int end = s.length() - 1;
            String result = s.toUpperCase();
            while (start < end) {
                char startChar = result.charAt(start);
                if (!isNumOrLetter(startChar)) {
                    start++;
                    continue;
                }
                char endChar = result.charAt(end);
                if (!isNumOrLetter(endChar)) {
                    end--;
                    continue;
                }
                if (startChar == endChar) {
                    start++;
                    end--;
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isNumOrLetter(char character) {
        if ((character > '0' && character < '9') || (character > 'A' && character < 'Z')) {
            return true;
        } else {
            return false;
        }
    }

    //    字符串转换整数 (atoi)
//    请你来实现一个 atoi 函数，使其能将字符串转换成整数。
//
//    首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
//
//    当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
//
//    该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
//
//    注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
//
//    在任何情况下，若函数不能进行有效的转换时，请返回 0。
//
//    说明：
//
//    假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        } else {
            long result = 0;
            int flag = 0;
            str = str.trim();
            for (int i = 0; i < str.length(); i++) {
                if (i == 0) {
                    if (str.charAt(i) != '-') {
                        int temp = getNum(str.charAt(i));
                        if (temp >= 0) {
                            result += temp;
                        } else {
                            return 0;
                        }
                    } else {
                        flag = -1;
                    }
                } else {
                    int temp = getNum(str.charAt(i));
                    if (temp >= 0) {
                        result = result * 10 + temp;
                        if (flag == 0) {
                            if (result > Integer.MAX_VALUE) {
                                return Integer.MAX_VALUE;
                            }
                        } else if (flag == -1) {
                            if (-result < Integer.MIN_VALUE) {
                                return Integer.MIN_VALUE;
                            }
                        }

                    } else {
                        break;
                    }
                }
            }
            return (int) (flag == 0 ? result : -result);
        }
    }

    public int getNum(char element) {
        if (element >= '0' && element <= '9') {
            return element - '0';
        } else {
            return -1;
        }
    }


    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    //外观数列
//「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
//
//            1.     1
//            2.     11
//            3.     21
//            4.     1211
//            5.     111221
//            1 被读作  "one 1"  ("一个一") , 即 11。
//            11 被读作 "two 1s" ("两个一"）, 即 21。
//            21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
//
//    给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
//
//    注意：整数序列中的每一项将表示为一个字符串。
    public String countAndSay(int n) {
        String[] result = new String[n];
        for (int i = 0; i < result.length; i++) {
            if (i == 0) {
                result[i] = "1";
            } else if (i == 1) {
                result[i] = "11";
            } else {
                StringBuffer stringBuffer = new StringBuffer("");
                String temp = result[i - 1];
                char lastElement = temp.charAt(0);
                int count = 1;
                for (int j = 1; j < temp.length(); j++) {
                    char element = temp.charAt(j);
                    if (temp.charAt(j) == lastElement) {
                        count++;
                    } else {
                        stringBuffer.append(count);
                        stringBuffer.append(lastElement);
                        lastElement = temp.charAt(j);
                        count = 1;
                    }
                }
                stringBuffer.append(count);
                stringBuffer.append(lastElement);
                result[i] = stringBuffer.toString();
            }
        }
        return result[n - 1];
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        } else if (strs.length == 2) {
            return strs[0];
        } else {
            String temp = strs[0];
            while (temp.length() > 0) {
                boolean isInterupt = false;
                for (int i = 1; i < strs.length; i++) {
                    if (!strs[i].startsWith(temp)) {
                        temp = temp.substring(0, temp.length() - 1);
                        isInterupt = true;
                        break;
                    }
                }
                if (!isInterupt) {
                    return temp;
                }
            }
        }
        return "";
    }

    //    请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
//
//    现有一个链表 -- head = [4,5,1,9]，它可以表示为:
//
//
//
//
//
//    示例 1:
//
//    输入: head = [4,5,1,9], node = 5
//    输出: [4,1,9]
//    解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
//    示例 2:
//
//    输入: head = [4,5,1,9], node = 1
//    输出: [4,5,9]
//    解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    //    给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
//    示例：
//
//    给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//    当删除了倒数第二个节点后，链表变为 1->2->3->5.
//    说明：
//
//    给定的 n 保证是有效的。
//
//    进阶：
//
//    你能尝试使用一趟扫描实现吗？
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> resultList = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            resultList.add(temp);
            temp = temp.next;
        }
        if (n > resultList.size()) {
            return null;
        } else if (n == resultList.size()) {
            if (resultList.size() > 1) {
                return resultList.get(1);
            } else {
                return null;
            }
        } else {
            if (n == 1) {
                resultList.get(resultList.size() - n - 1).next = null;
            } else {
                resultList.get(resultList.size() - n - 1).next = resultList.get(resultList.size() - n + 1);
            }
            return resultList.get(0);
        }
    }

    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> result = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            result.add(node.val);
            node = node.next;
        }
        int start = 0;
        int end = result.size() - 1;
        while (start < end) {

            if (!result.get(start).equals(result.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> resultHash = new HashSet<>();
        ListNode node = head;
        while (node != null) {

            if (resultHash.contains(node)) {
                return true;
            } else {
                resultHash.add(node);
            }
            node = node.next;
        }
        return false;
    }

    //    验证二叉搜索树
//    给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
//    假设一个二叉搜索树具有如下特征：
//
//    节点的左子树只包含小于当前节点的数。
//    节点的右子树只包含大于当前节点的数。
//    所有左子树和右子树自身必须也是二叉搜索树。
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long mn, long mx) {
        if (root == null) {
            return true;
        }
        if (root.val <= mn || root.val >= mx) return false;
        return isValidBST(root.left, mn, root.val) && isValidBST(root.right, root.val, mx);
    }

    //例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//            1
//            / \
//            2   2
//            / \ / \
//            3  4 4  3
//            # 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//            1
//            / \
//            2   2
//            \   \
//            3    3
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return isSymmetric(root.left, root.right);
        }
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right != null) {
            return (left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left));
        } else {
            return false;
        }
    }

    //    二叉树的层次遍历
//    给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
//
//    例如:
//    给定二叉树: [3,9,20,null,null,15,7],
//
//            3
//            / \
//            9  20
//            /  \
//            15   7
//    返回其层次遍历结果：
//
//            [
//            [3],
//            [9,20],
//            [15,7]
//            ]
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root != null) {
            List<TreeNode> temp = new ArrayList<>();
            temp.add(root);
            levelOrder(temp, result);
        }
        return result;

    }

    private void levelOrder(List<TreeNode> temp, List<List<Integer>> result) {
        if (temp == null || temp.size() == 0) {
            return;
        }
        List<TreeNode> temp2 = new ArrayList<>();
        List<Integer> temp3 = new ArrayList<>();
        for (TreeNode node : temp) {
            if (node != null) {
                temp3.add(node.val);
            }
            if (node.left != null) {
                temp2.add(node.left);
            }
            if (node.right != null) {
                temp2.add(node.right);
            }
        }
        result.add(temp3);
        if (temp2.size() > 0) {
            levelOrder(temp2, result);
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        } else {
            int start = 0;
            int end = nums.length - 1;
            return sortedArrayToBST(nums, start, end);
        }
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            int mid = (end - start) / 2 + start;
            if (mid >= start && mid <= end) {
                TreeNode node = new TreeNode(nums[mid]);
                if (mid > start) {
                    node.left = sortedArrayToBST(nums, start, mid - 1);
                }
                if (mid < end) {
                    node.right = sortedArrayToBST(nums, mid + 1, end);
                }
                return node;
            } else {
                return null;
            }
        }
    }

    /**
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     * <p>
     * 说明:
     * <p>
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * 示例:
     * <p>
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * <p>
     * 输出: [1,2,2,3,5,6]
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (j >= 0) {
            nums1[k--] = i >= 0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
    }
}