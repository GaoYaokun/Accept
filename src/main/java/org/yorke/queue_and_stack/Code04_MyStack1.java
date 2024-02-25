package org.yorke.queue_and_stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Yorke
 * @Date: 2024/2/24 11:40
 */
public class Code04_MyStack1 {
    public static void main(String[] args) {
        Code04_MyStack1 myStack = new Code04_MyStack1();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.empty()); // 返回 False
    }

    Queue<Integer> queue;
    // n 用来记录栈中元素个数
    int n = 0;

    /** Initialize your data structure here.
     *  仅使用 1 个队列构建栈
     * */
    public Code04_MyStack1() {
        this.queue = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        for(int i = 0; i < n; i ++) {
            queue.offer(queue.poll());
        }
        n ++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        n --;
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return n == 0;
    }
}
