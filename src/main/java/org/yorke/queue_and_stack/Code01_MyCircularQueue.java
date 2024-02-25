package org.yorke.queue_and_stack;

/**
 * @Author: Yorke
 * @Date: 2024/2/24 11:12
 *
 * LC622 设计循环链表
 *
 * 你的实现应该支持如下操作：
 *
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 *
 */
public class Code01_MyCircularQueue {
    public static void main(String[] args) {
        Code01_MyCircularQueue circularQueue = new Code01_MyCircularQueue(3);
        System.out.println(circularQueue.enQueue(1));  // 返回 true
        System.out.println(circularQueue.enQueue(2));  // 返回 true
        System.out.println(circularQueue.enQueue(3));  // 返回 true
        System.out.println(circularQueue.enQueue(4));  // 返回 false，队列已满
        System.out.println(circularQueue.Rear());  // 返回 3
        System.out.println(circularQueue.isFull());  // 返回 true
        System.out.println(circularQueue.deQueue());  // 返回 true
        System.out.println(circularQueue.enQueue(4));  // 返回 true
        System.out.println(circularQueue.Rear());  // 返回 4
    }

    int[] cq;
    int head = 0;
    int tail = 0;
    int size = 0;

    public Code01_MyCircularQueue(int k) {
        this.cq = new int[k];
    }

    public boolean enQueue(int value) {
        if(isFull()) return false;
        size ++;
        cq[tail++] = value;
        tail = tail == cq.length ? 0 : tail;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;
        size --;
        head ++;
        head = head == cq.length ? 0 : head;
        return true;
    }

    public int Front() {
        if(isEmpty()) return -1;
        return cq[head];
    }

    public int Rear() {
        if(isEmpty()) return -1;
        int rear = tail - 1 < 0 ? cq.length - 1 : tail - 1;
        return cq[rear];
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public boolean isFull() {
        return size == cq.length ? true : false;
    }
}
