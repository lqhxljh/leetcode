package com.lqhx.leetcode;

public class ArraySolution {

    /**
     * 寻找数组的中心索引
     * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
     * <p>
     * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
     * <p>
     * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * nums = [1, 7, 3, 6, 5, 6]
     * 输出: 3
     * 解释:
     * 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
     * 同时, 3 也是第一个符合要求的中心索引。
     * 示例 2:
     * <p>
     * 输入:
     * nums = [1, 2, 3]
     * 输出: -1
     * 解释:
     * 数组中不存在满足此条件的中心索引。
     * 说明:
     * <p>
     * nums 的长度范围为 [0, 10000]。
     * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
     */

    public int pivotIndex(int[] nums) {
        if (nums != null) {
            if (nums.length == 0) {
                return 0;
            }
            int[] total = new int[nums.length];
            total[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                total[i] = nums[i] + total[i - 1];

            }
            for (int i = 0; i < nums.length; i++) {
                int leftTotal = i == 0 ? 0 : total[i - 1];
                int rightTotal = i == nums.length - 1 ? 0 : total[total.length - 1] - total[i];
                if (leftTotal == rightTotal) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 至少是其他数字两倍的最大数
     * 在一个给定的数组nums中，总是存在一个最大元素 。
     * <p>
     * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
     * <p>
     * 如果是，则返回最大元素的索引，否则返回-1。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [3, 6, 1, 0]
     * 输出: 1
     * 解释: 6是最大的整数, 对于数组中的其他整数,
     * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
     * <p>
     * <p>
     * 示例 2:
     * <p>
     * 输入: nums = [1, 2, 3, 4]
     * 输出: -1
     * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
     */
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return 0;
        } else {
            int maxPosition = 0;
            int secondMaxPosition = 0;
            if (nums[1] >= nums[0]) {
                maxPosition = 1;
            } else {
                secondMaxPosition = 1;
            }
            for (int i = 2; i < nums.length; i++) {
                if (nums[i] >= nums[maxPosition]) {
                    secondMaxPosition = maxPosition;
                    maxPosition = i;
                } else if (nums[i] >= nums[secondMaxPosition]) {
                    secondMaxPosition = i;
                }
            }
            if (nums[maxPosition] >= 2 * nums[secondMaxPosition]) {
                return maxPosition;
            }
        }
        return -1;
    }
}
