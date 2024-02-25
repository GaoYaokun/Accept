package org.yorke.queue_and_stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Yorke
 * @Date: 2024/2/24 11:21
 *
 * LC225 用队列实现栈
 *
 * 实现 MyStack 类：
 *
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false
 */
public class Code03_MyStack {
    public static void main(String[] args) {
        Code03_MyStack myStack = new Code03_MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.empty()); // 返回 False
    }

    Queue<Integer> q1;
    Queue<Integer> q2;

    /** Initialize your data structure here.
     *  使用2个队列构建栈
     * */
    public Code03_MyStack() {
        this.q1 = new LinkedList<Integer>();
        this.q2 = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q2.offer(x);
        while(!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.poll();
    }

    /** Get the top element. */
    public int top() {
        return q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
