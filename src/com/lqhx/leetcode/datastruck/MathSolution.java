package com.lqhx.leetcode.datastruck;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class MathSolution {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        int result[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i <= 1) {
                result[i] = 0;
            } else if (i == 2) {
                result[i] = 1;
            } else if (i == 3 || i == 4) {
                result[i] = 2;
            } else {
                if (i % 2 == 0) {
                    result[i] = result[i - 1];
                } else {
                    int sqrt = (int) Math.sqrt(i);
                    int flag = 0;
                    for (int j = 3; j <= sqrt; j++) {
                        if (i % j == 0) {
                            flag = 1;
                            break;
                        }
                    }
                    result[i] = (flag == 0 ? result[i - 1] + 1 : result[i - 1]);
                }
            }
        }
        return result[n - 1];
    }

    //    bool is(long long n)
//    {
//        if (n <= 0) return false;
//        long long max = (long long)pow(3, (long long)(log(0xfffffff)/log(3)));
//        if (max % n == 0) return true;
//        else return false;
//    }
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        } else {
            int maxPow = (int) (Math.log10(Integer.MAX_VALUE) / Math.log10(3));
            long max = (long) Math.pow(3, maxPow);
            if (max % n == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                result += map.get(s.charAt(i));
            } else {
                result -= map.get(s.charAt(i));
            }
        }
        return result;
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

    /**
     * 汉明距离
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     * <p>
     * 给出两个整数 x 和 y，计算它们之间的汉明距离。
     * <p>
     * 注意：
     * 0 ≤ x, y < 231.
     * <p>
     * 示例:
     * <p>
     * 输入: x = 1, y = 4
     * <p>
     * 输出: 2
     * <p>
     * 解释:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     * ↑   ↑
     * <p>
     * 上面的箭头指出了对应二进制位不同的位置。
     */
    public int hammingDistance(int x, int y) {
        int temp = 0B000000000000000000000001;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((x & temp) != (y & temp)) {
                result++;
            }
            temp = temp << 1;
        }
        return result;
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int temp = 0B000000000000000000000001;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + ((n & temp) == temp ? 1 : 0);
            temp = temp << 1;
        }
        return result;
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        } else {
            Stack<Character> contains = new Stack<>();
            HashMap<Character, Character> hashMap = new HashMap<>();
            hashMap.put('}', '{');
            hashMap.put(']', '[');
            hashMap.put(')', '(');
            for (int i = 0; i < s.length(); i++) {
                if (hashMap.get(s.charAt(i)) != null) {
                    if (contains.size() > 0) {
                        if (!contains.pop().equals(hashMap.get(s.charAt(i)))) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    contains.add(s.charAt(i));
                }
            }
            if (contains.size() > 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    public int missingNumber(int[] nums) {
        if (nums == null)
        {
            return 0;
        }
        HashSet<Integer> resultContains = new HashSet<>();
        int count = nums.length;
        int i = 0;
        while (i <= count + 1)
        {
            resultContains.add(i);
        }
        for (int num : nums) {
            resultContains.remove(num);
        }
        if (resultContains.iterator().hasNext())
        {
            return resultContains.iterator().next();
        }else
        {
            return 0;
        }
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            HashSet<Character> line = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for(int j = 0; j < 9; j++){
                if('.' != board[i][j] && !line.add(board[i][j]))
                    return false;
                if('.' != board[j][i] && !col.add(board[j][i]))
                    return false;
                int m = i/3*3+j/3;
                int n = i%3*3+j%3;
                if('.' != board[m][n] && !cube.add(board[m][n]))
                    return false;
            }
        }
        return true;
    }
}
