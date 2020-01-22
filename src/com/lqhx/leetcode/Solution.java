package com.lqhx.leetcode;

import com.lqhx.leetcode.DataStruck.ListNode;

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
                if (startChar == endChar)
                {
                    start++;
                    end--;
                    continue;
                }else{
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
}
