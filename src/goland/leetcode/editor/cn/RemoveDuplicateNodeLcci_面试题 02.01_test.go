package leetcode

import (
	"testing"
)

// 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
//
// 示例1:
//
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
//
// 示例2:
//
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
//
// 提示：
//
// 链表长度在[0, 20000]范围内。
// 链表元素在[0, 20000]范围内。
//
// 进阶：
//
// 如果不得使用临时缓冲区，该怎么解决？
//
// Related Topics 哈希表 链表 双指针 👍 197 👎 0
type ListNode struct {
	Val  int
	Next *ListNode
}

// leetcode submit region begin(Prohibit modification and deletion)

func removeDuplicateNodes(head *ListNode) *ListNode {
	if head == nil {
		return head
	}
	occurred := map[int]bool{head.Val: true}
	pos := head
	for pos.Next != nil {
		cur := pos.Next
		if !occurred[cur.Val] {
			occurred[cur.Val] = true
			pos = pos.Next
		} else {
			pos.Next = pos.Next.Next
		}
	}
	pos.Next = nil
	return head
}

//leetcode submit region end(Prohibit modification and deletion)

func TestRemoveDuplicateNodeLcci(t *testing.T) {
	// 构建nodeList 顺序1, 2, 3, 3, 2, 1
	nodeList := &ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 2,
			Next: &ListNode{
				Val: 3,
				Next: &ListNode{
					Val: 3,
					Next: &ListNode{
						Val: 2,
						Next: &ListNode{
							Val: 1,
						},
					},
				},
			},
		},
	}
	removeDuplicateNodes(nodeList)
}
