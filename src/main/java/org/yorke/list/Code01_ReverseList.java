package org.yorke.list;

/**
 * @Author: Yorke
 * @Date: 2024/2/23 9:13
 */
public class Code01_ReverseList {
    public static void main(String[] args) {
        ListNode node3 = new ListNode(3, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode res = recurReverseList(node1);

        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    //迭代法
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode pre = null;
        ListNode next = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //递归法
    public static ListNode recurReverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        return recurReverseList(head, null);
    }

    public static ListNode recurReverseList(ListNode head, ListNode pre) {
        if(head == null) return pre;

        ListNode res = recurReverseList(head.next, head);
        head.next = pre;

        return res;
    }
}
