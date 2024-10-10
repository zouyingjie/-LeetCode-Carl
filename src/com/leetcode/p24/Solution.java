package com.leetcode.p24;

import com.leetcode.common.ListNode;

public class Solution {
    /**
     * 遍历链表，两两交换
     *
     * 一对node (node1, node2)
     * 相邻node: node1.pre, node2.next
     *
     * 一次交换涉及到上述几个元素
     * node1.next = node2.next
     * node2.next = node1
     * node1.pre.next = node2
     *
     * corner case:
     *
     * node1 == null 或者 node2 == null，则不进行交换，直接返回
     * pre == null，即第一对交换，不需要处理 pre.next
     *
     *
     * @return
     */
    public  ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // head 指向了 node1，但 node1 的 next 会变化，因此需要事先记录下最新的 head 节点
        ListNode result = head.next;

        ListNode pre = null;
        ListNode node1 = head;
        ListNode node2 = head.next;

        this.swap(pre, node1, node2);

        return result;
    }

    private void swap(ListNode pre, ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return;
        }

        node1.next = node2.next;
        node2.next = node1;
        if (pre != null) {
            pre.next = node2;
        }

        if (node1.next == null) {
            return;
        }
        swap(node1, node1.next, node1.next.next);
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);

        Solution solution = new Solution();
        solution.swapPairs(node);
    }
}
