package com.lqhx.leetcode;

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
}

