package leetcode

import (
	"testing"
)

//若链表中的某个节点，既不是链表头节点，也不是链表尾节点，则称其为该链表的「中间节点」。
//
// 假定已知链表的某一个中间节点，请实现一种算法，将该节点从链表中删除。
//
// 例如，传入节点 c（位于单向链表 a->b->c->d->e->f 中），将其删除后，剩余链表为 a->b->d->e->f
//
//
//
// 示例：
//
//
//输入：节点 5 （位于单向链表 4->5->1->9 中）
//输出：不返回任何数据，从链表中删除传入的节点 5，使链表变为 4->1->9
//
//
//
//
// Related Topics 链表 👍 199 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func deleteNode(node *ListNode) {
	next := node.Next
	node.Val = next.Val
	node.Next = next.Next
}

//leetcode submit region end(Prohibit modification and deletion)

func TestDeleteMiddleNodeLcci(t *testing.T) {

}
