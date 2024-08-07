//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 10⁴] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
//
// Related Topics 递归 链表 👍 1434 👎 0


package leetcode.editor.cn;

import leetcode.editor.common.ListNode;

/**
 * 移除链表元素
 *
 * @author DY
 * @date 2024-07-01 17:02:02
 */
public class RemoveLinkedListElements_203 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new RemoveLinkedListElements_203().new Solution();
        ListNode listNode = solution.removeElements(new ListNode(6, 2, 6, 3, 4, 5, 6), 6);
        System.out.println(listNode);
    }

    //力扣代码
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
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            head.next = removeElements(head.next, val);
            if (head.val == val) {
                return head.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}