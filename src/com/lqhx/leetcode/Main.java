package com.lqhx.leetcode;


import com.lqhx.leetcode.DataStruck.MathSolution;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.toString());
        MathSolution mathSolution = new MathSolution();
        System.out.println(mathSolution.countPrimes(10));
        System.out.println(mathSolution.isPowerOfThree(27));
        System.out.println(mathSolution.hammingWeight(0B11111111111111111111111111111101));
        System.out.println(mathSolution.hammingDistance(4, 1));
        System.out.println(mathSolution.isValid("()"));
        RecursiveSolution recursiveSolution = new RecursiveSolution();
        System.out.println(recursiveSolution.kthGrammar(2, 2));
        System.out.println(recursiveSolution.kthGrammar(4, 5));
        int[] xxx = {1, 7, 3, 6, 5, 6};
        System.out.println(recursiveSolution.pivotIndex(xxx));

    }
}
