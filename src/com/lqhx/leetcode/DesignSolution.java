package com.lqhx.leetcode;

import java.util.Random;

public class DesignSolution {
    // 以数字集合 1, 2 和 3 初始化数组。
    private int[] nums;

    public DesignSolution(int[] nums) {
        this.nums = nums;
    }

    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
    public int[] shuffle() {
        int[] temp = nums.clone();
        int[] resultArray = new int[temp.length];
        Random random = new Random();
        for (int i = 0; i < temp.length; i++) {
            int position = random.nextInt(temp.length - i);
            resultArray[i] = temp[position];
            for (int j = position; j < temp.length - i - 1; j++) {
                temp[j] = temp[j + 1];
            }
        }
        return resultArray;
    }
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

}
