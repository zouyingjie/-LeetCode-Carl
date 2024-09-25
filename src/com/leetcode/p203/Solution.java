package com.leetcode.p203;

import com.leetcode.common.ListNode;

/**
 * 加一个哨兵节点，这样 header 节点和其他节点本质上就一样了
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinelNode = new ListNode(1, head);
        ListNode  preNode= sentinelNode;
        ListNode node = head;
        while (node != null) {
            if (node.val == val) {
                preNode.next = node.next;
                node = node.next;
            }else {
                preNode = preNode.next;
                node = node.next;
            }
        }
        return sentinelNode.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        ListNode sentinelNode = new ListNode(1, head);
        ListNode node = sentinelNode;
        while (node != null) {
            if (node.next != null && node.next.val == val) {
                node.next = node.next.next;
            }else {
                node = node.next;
            }
        }
        return sentinelNode.next;
    }
}
