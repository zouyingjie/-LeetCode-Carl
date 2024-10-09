package com.leetcode.p707;

class Node {
    public int val;
    public Node next;
    public Node(int val) {
        this.val = val;
    }

}
/**
 * 单链表
 *
 * 单纯的链表处理是比较简单的，麻烦的是遇到几个特殊的节点时的处理：
 *
 * - 添加到头节点，删除头节点，注意 header 指针的处理
 * - 删除到尾结点，需要将 tail 指针指向前一个节点
 */
class MyLinkedList {
    private Node header;
    private Node tail;
    int size = 0;
    
    public MyLinkedList() {
        header = null;
        tail = null;
    }

    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }

        int i = 0;
        Node node = header;
        while (i != index) {
            node = node.next;
            i ++;
        }
        return node.val;
    }

    public void addAtHead(int val) {
        Node newHead= new Node(val);
        newHead.next = header;
        header = newHead;
        size ++;
        if (tail == null) {
            tail = newHead;
        }
    }

    public void addAtTail(int val) {
        if (header == null) {
            addAtHead(val);
            return;
        }

        Node newTail = new Node(val);
        tail.next = newTail;
        tail = newTail;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if(index == size) {
            addAtTail(val);
            return;
        }

        int i = 1;
        Node previous = header;
        Node node = header.next;
        while (i != index) {
            node = node.next;
            previous = previous.next;
            i ++;
        }

        Node newNode = new Node(val);
        newNode.next = node;
        previous.next = newNode;
        size ++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        if (index == 0) {
            header = header.next;
            if (size == 1) {
                tail = header;
            }
            size --;
            return;
        }

        int i = 1;
        Node node = header.next;
        Node previous = header;
        while (i != index) {
            node = node.next;
            previous = previous.next;
            i ++;
        }

        if (index == size - 1) {
            previous.next = null;
            tail = previous;
        }else {
            previous.next = node.next;
        }


        size --;
    }

}

