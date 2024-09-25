package p203

type ListNode struct {
	Val  int
	Next *ListNode
}

func removeElements(head *ListNode, val int) *ListNode {
	sentinelNode := &ListNode{0, head}

	node := sentinelNode

	for node != nil {
		if node.Next != nil && node.Next.Val == val {
			node.Next = node.Next.Next
		} else {
			node = node.Next
		}
	}
	return sentinelNode.Next
}
