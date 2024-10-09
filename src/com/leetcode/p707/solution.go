package main

type Node struct {
	Val  int
	Next *Node
	Pre  *Node
}

type MyLinkedList struct {
	Size   int
	header *Node
	tail   *Node
}

/*
*
双向链表实现

1. 每次节点变化需要变化 Pre、Next 两个指针
2. edge case: 新增 header、tail; 删除 header、tail; heaer 和 tail 是同一个
*/
func Constructor() MyLinkedList {
	return MyLinkedList{0, nil, nil}
}

func (this *MyLinkedList) Get(index int) int {
	if index < 0 || index >= this.Size {
		return -1
	}

	node := this.header
	for i := 0; i != index; i++ {
		node = node.Next
	}
	return node.Val
}

func (this *MyLinkedList) AddAtHead(val int) {
	if this.header == nil {
		this.header = &Node{val, nil, nil}
		this.tail = this.header
	} else {
		newHeader := &Node{val, this.header, nil}
		this.header.Pre = newHeader
		this.header = newHeader
	}
	this.Size++

}

func (this *MyLinkedList) AddAtTail(val int) {
	if this.tail == nil {
		this.AddAtHead(val)
		return
	}

	newTail := &Node{val, nil, this.tail}
	this.tail.Next = newTail
	this.tail = newTail
	this.Size++
}

func (this *MyLinkedList) AddAtIndex(index int, val int) {
	if index < 0 || index > this.Size {
		return
	}
	if index == 0 {
		this.AddAtHead(val)
		return
	}

	if index == this.Size {
		this.AddAtTail(val)
		return
	}

	node := this.header.Next
	for i := 1; i != index; i++ {
		node = node.Next
	}

	newNode := &Node{val, node, node.Pre}
	node.Pre.Next = newNode
	node.Pre = newNode
	this.Size++
}

func (this *MyLinkedList) DeleteAtIndex(index int) {
	if index < 0 || index >= this.Size {
		return
	}
	if index == 0 {
		this.deleteHeader()
		return
	}
	if index == this.Size-1 {
		this.deleteTail()
		return
	}

	node := this.header.Next
	for i := 1; i != index; i++ {
		node = node.Next
	}

	node.Next.Pre = node.Pre
	node.Pre.Next = node.Next
	node.Next = nil
	node.Pre = nil
	this.Size--

}

func (this *MyLinkedList) deleteHeader() {
	if this.tail == this.header {
		this.header = nil
		this.tail = nil
	} else {
		oldHeader := this.header
		this.header.Next.Pre = nil
		this.header = this.header.Next
		oldHeader.Next = nil
	}
	this.Size--
}

func (this *MyLinkedList) deleteTail() {
	if this.tail == this.header {
		this.header = nil
		this.tail = nil
	} else {
		oldTail := this.tail
		this.tail.Pre.Next = nil
		this.tail = this.tail.Pre
		oldTail.Pre = nil
	}
	this.Size--
}

func main() {
	obj := Constructor()
	obj.AddAtHead(1)
	obj.AddAtTail(3)
	obj.AddAtIndex(3, 2)
	obj.Get(1)
	obj.DeleteAtIndex(1)
	obj.Get(1)

}
