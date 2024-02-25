package org.yorke.queue_and_stack;

import java.util.Stack;

/**
 * @Author: Yorke
 * @Date: 2024/2/24 11:18
 *
 * LC232 使用两个栈实现队列
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 */
public class Code02_MyQueue {
    public static void main(String[] args) {
        Code02_MyQueue myQueue = new Code02_MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public Code02_MyQueue() {
        this.stack1 = new Stack();
        this.stack2 = new Stack();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if(!stack2.isEmpty()) return stack2.pop();
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public int peek() {
        if(!stack2.isEmpty()) return stack2.peek();
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    public boolean empty() {
        return (stack1.isEmpty() && stack2.isEmpty()) ? true : false;
    }
}
