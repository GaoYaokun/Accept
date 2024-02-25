package org.yorke.queue_and_stack;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Yorke
 * @Date: 2024/2/24 18:06
 *
 * LC641 设计实现双端队列。
 *
 * 实现 MyCircularDeque 类:
 *
 * MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
 * boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
 * boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
 * boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
 * boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
 * int getFront() ：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
 * int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
 * boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false  。
 * boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。
 */
public class Code06_MyCircularDequeue {
    public static void main(String[] args) {

        Code06_MyCircularDequeue circularDeque = new Code06_MyCircularDequeue(3); // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1));			        // 返回 true
        System.out.println(circularDeque.insertLast(2));			        // 返回 true
        System.out.println(circularDeque.insertFront(3));			        // 返回 true
        System.out.println(circularDeque.insertFront(4));			        // 已经满了，返回 false
        System.out.println(circularDeque.getRear());  				// 返回 2
        System.out.println(circularDeque.isFull());				        // 返回 true
        System.out.println(circularDeque.deleteLast());			        // 返回 true
        System.out.println(circularDeque.insertFront(4));			        // 返回 true
        System.out.println(circularDeque.getFront());				// 返回 4

    }

    Deque<Integer> deque;
    int size = 0;
    int limit = 0;

    public Code06_MyCircularDequeue(int k) {
        this.deque = new LinkedList<>();
        this.limit = k;
    }

    public boolean insertFront(int value) {
        if(size == limit) return false;
        deque.offerFirst(value);
        size ++;
        return true;
    }

    public boolean insertLast(int value) {
        if(size == limit) return false;
        deque.offerLast(value);
        size ++;
        return true;
    }

    public boolean deleteFront() {
        if(size == 0) return false;
        deque.pollFirst();
        size --;
        return true;
    }

    public boolean deleteLast() {
        if(size == 0) return false;
        deque.pollLast();
        size --;
        return true;
    }

    public int getFront() {
        if(size == 0) return -1;
        return deque.peekFirst();
    }

    public int getRear() {
        if(size == 0) return -1;
        return deque.peekLast();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == limit;
    }
}
