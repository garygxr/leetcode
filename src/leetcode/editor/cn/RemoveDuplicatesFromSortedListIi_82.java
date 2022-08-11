//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
// Related Topics 链表 双指针 👍 960 👎 0

package leetcode.editor.cn;

import leetcode.editor.common.ListNode;

/**
 * @author gary gan
 * @date 2022-08-04 11:03:34
 */
public class RemoveDuplicatesFromSortedListIi_82 {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi_82().new Solution();
        ListNode listNode = ListNode.buildListNode(new ListNode(0), 0, 1, 2, 2, 3);
        ListNode listNode1 = solution.deleteDuplicates2(listNode.next);
        System.out.println(listNode1);
    }
    /**
     * 删除排序链表中的重复元素 II
     */
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode listNode = new ListNode(0, head);
            ListNode currentNode = listNode;
            while (currentNode.next != null && currentNode.next.next != null) {
                if (currentNode.next.val == currentNode.next.next.val) {
                    int x = currentNode.next.val;
                    while (currentNode.next != null && currentNode.next.val == x) {
                        currentNode.next = currentNode.next.next;
                    }
                } else {
                    currentNode = currentNode.next;
                }
            }
            return listNode.next;
        }

        public ListNode deleteDuplicates2(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            if (head.val != head.next.val) {
                head.next = deleteDuplicates2(head.next);
            } else {
                ListNode move = head.next;
                while (move!=null && head.val == move.val) {
                    move = move.next;
                }
                return deleteDuplicates2(move);
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}