package org.yorke.list;

import java.util.List;

/**
 * @Author: Yorke
 * @Date: 2024/2/23 15:53
 *
 * LC86 分隔链表
 * 给定链表 list 和 值x
 * 将list划分为 <x 和 >=x 两个区域， 且小于部分出现在大于等于部分之前
 * 请保持链表中节点的相对位置顺序
 *
 */
public class Code04_PartitionList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        int x = 3;

        ListNode res = partition(head, x);

        while(res != null) {
            System.out.print(res.val);
            System.out.print(" ");
            res = res.next;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;

        ListNode bigHead = new ListNode(0);
        ListNode bigTail = bigHead;
        ListNode smlHead = new ListNode(0);
        ListNode smlTail = smlHead;

        while(head != null) {
            if(head.val < x) {
                smlTail.next = head;
                smlTail = smlTail.next;
            }else {
                bigTail.next = head;
                bigTail = bigTail.next;
            }
            head = head.next;
        }

        smlTail.next = bigHead.next;
        bigTail.next = null;
        return smlHead.next;
    }
}
