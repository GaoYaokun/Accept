package org.yorke.list;


/**
 * @Author: Yorke
 * @Date: 2024/2/23 11:07
 *
 * LC2 两数之和
 * 两个数以链表逆序的形式给出
 * 例如 num1 = 342, 链表形式list1表示为 2 ——> 4 ——> 3 ——> null
 * 结果也以链表逆序的形式返回
 */
public class Code03_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode num1 = new ListNode(2);
        num1.next = new ListNode(4);
        num1.next.next = new ListNode(3);

        ListNode num2 = new ListNode(5);
        num2.next = new ListNode(6);
        num2.next.next = new ListNode(4);

        ListNode res = addTwoNumbers(num1, num2);

        while(res != null) {
            System.out.print(res.val);
            System.out.print(" ");
            res = res.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return l1 == null ? l2 : l1;

        ListNode head = new ListNode(0);
        ListNode res = head;

        int pre = 0;
        int next = 0;
        while(l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int cur = num1 + num2 + pre;

            next = cur / 10;
            cur = cur % 10;

            head.next = new ListNode(cur);
            head = head.next;

            pre = next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (pre == 1) head.next = new ListNode(1);

        return res.next;
    }


}
