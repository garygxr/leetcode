//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 9634 👎 0


package leetcode.editor.cn;

import leetcode.editor.common.ListNode;

/**
 * 两数相加
 *
 * @author DY
 * @date 2023-06-02 10:18:32
 */
public class AddTwoNumbers_2 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new AddTwoNumbers_2().new Solution();
        ListNode listNode1 = new ListNode(9, 8, 7, 6, 5, 4, 3, 2, 1);
        ListNode listNode = solution.addTwoNumbers(new ListNode(2,4,3), new ListNode(5,6,4));
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode node = new ListNode(0);
            ListNode current = node;
            int yu = 0;
            while (l1 != null || l2 != null || yu != 0) {
                int val = l1 == null ? 0 : l1.val;
                int val1 = l2 == null ? 0 : l2.val;
                int i = val + val1 + yu;
                int i1 = i % 10;
                yu = i / 10;
                current.next = new ListNode(i1);
                current = current.next;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }

            return node.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}