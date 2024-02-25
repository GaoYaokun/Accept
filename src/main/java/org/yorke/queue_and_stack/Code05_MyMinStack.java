package org.yorke.queue_and_stack;

import java.sql.SQLOutput;
import java.util.Stack;

/**
 * @Author: Yorke
 * @Date: 2024/2/24 17:40
 *
 * LC155 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 */
public class Code05_MyMinStack {
    public static void main(String[] args) {
        Code05_MyMinStack minStack = new Code05_MyMinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   //--> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());      //--> 返回 0.
        System.out.println(minStack.getMin());   //--> 返回 -2.
    }

    Stack<Integer> stack;
    Stack<Integer> minStack;
    public Code05_MyMinStack() {
        this.stack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()) {
            minStack.push(val);
        }else {
            minStack.push(val < minStack.peek() ? val : minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
