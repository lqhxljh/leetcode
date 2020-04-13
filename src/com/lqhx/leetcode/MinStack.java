package com.lqhx.leetcode;

import java.util.LinkedList;
import java.util.Stack;

class MinStack {
    Stack<Integer> stack = new Stack<>() ;
    Stack<Integer>  minStack = new Stack<>() ;
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if(minStack.empty()){
            minStack.push(x);
        }else if(minStack.peek() >= x){
            minStack.push(x);
        }
    }

    public void pop() {
        int data = stack.pop();
        if(data == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}