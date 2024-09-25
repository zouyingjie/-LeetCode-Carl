package com.leetcode.p206;


import com.leetcode.common.ListNode;

import java.awt.*;

public class Solution {
    /**
     * 循环
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode node = head;
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList02(ListNode head) {
        return reverse(null, head);

    }

    private ListNode reverse(ListNode pre, ListNode node) {
        if (node == null) {
            return pre;
        }

        ListNode next = node.next;
        node.next = pre;
        return reverse(node, next);
    }

}