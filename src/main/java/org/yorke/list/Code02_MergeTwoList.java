package org.yorke.list;

import java.util.List;

/**
 * @Author: Yorke
 * @Date: 2024/2/23 10:22
 */
public class Code02_MergeTwoList {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(3);
        list1.next = new ListNode(6);
        list1.next.next = new ListNode(9);
        list1.next.next.next = new ListNode(12);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(7);
        list2.next.next = new ListNode(10);
        list2.next.next.next = new ListNode(11);

        ListNode res = mergeTwoLists(list1, list2);

        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // if(list1 == null) return list2;
        // if(list2 == null) return list1;

        if(list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }


        ListNode head = new ListNode(0);
        ListNode res = head;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }

        // if(list1 == null) {
        //     head.next = list2;
        // } else{
        //     head.next = list1;
        // }

        head.next = list1 == null ? list2 : list1;

        return res.next;
    }
}
