//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 👍 2627 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import leetcode.editor.common.ListNode;

/**
 * @author gary gan
 * @date 2022-07-17 10:12:14
 */
public class ReverseLinkedList_206 {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList_206().new Solution();

        ListNode listNode = new MergeTwoSortedLists_21().buildListNode(new ListNode(0),0,new int[]{1,2,3});
        solution.reverseList(listNode);
    }
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
        public ListNode reverseList(ListNode head) {
            ListNode listNode = new ListNode(0);
            reverseList(head,listNode);
            return listNode.next;
        }

        public void reverseList(ListNode head, ListNode newListNode) {
            if (head==null){
                return;
            }

            reverseList(head.next,newListNode);
            newListNode.next=new ListNode(head.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}