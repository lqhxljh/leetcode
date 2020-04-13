package com.lqhx.leetcode;

public class DynamicSolution {
    /**
     * 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     
     * 注意：给定 n 是一个正整数。
     
     * 示例 1：
     
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     * 示例 2：
     
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     **/
    public int climbStairs(int n) {
        int[] result = new int[n];
        if (n == 0) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result[0] = 1;
            } else if (i == 1) {
                result[1] = 2;
            } else {
                result[i] = result[i - 1] + result[i - 2];
            }
        }
        return result[n - 1];
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     * 注意你不能在买入股票前卖出股票
     **/
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        } else {
            int max = 0;
            int min = prices[0];
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < min)
                    min = prices[i];
                if (prices[i] - min > max)
                    max = prices[i] - min;
            }
            return max;
        }
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else {
            int result = nums[0];
            int current = result;
            for (int i = 0; i < nums.length; i++) {
                if (current < 0) {
                    current = nums[i];
                } else {
                    current += nums[i];
                }
                if (current > result) {
                    result = current;
                }
            }
            return result;
        }
    }

    /**
     * 打家劫舍
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     * 示例 1:
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     * 偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 2:
     * 输入: [2,7,9,3,1]
     * 输出: 12
     * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else {
            int[] result = new int[nums.length];
            int[] resultPosition = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    result[0] = nums[0];
                    resultPosition[0] = 0;
                } else if (i == 1) {
                    result[1] = Math.max(nums[0], nums[1]);
                    resultPosition[1] = nums[0] < nums[1] ? 1 : 0;
                } else {
                    int positon = resultPosition[i - 1];
                    if (positon == (i - 1)) {
                        if (result[i - 1] > result[i - 2] + nums[i]) {
                            resultPosition[i] = i - 1;
                            result[i] = result[i - 1];
                        } else {
                            result[i] = result[i - 2] + nums[i];
                            resultPosition[i] = i;
                        }
                    } else {
                        result[i] = result[i - 2] + nums[i];
                        resultPosition[i] = i;
                    }
                }
            }
            return result[nums.length - 1];
        }
    }
}
