//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 👍 2536 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import leetcode.editor.common.ListNode;

/**
 * @author gary gan
 * @date 2022-07-17 07:08:20
 */
public class MergeTwoSortedLists_21 {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists_21().new Solution();
        ListNode listNode = buildListNode(new ListNode(0),0,new int[]{});
        ListNode listNode1 = buildListNode(new ListNode(0),0,new int[]{2,3,4});
        ListNode listNode2 = solution.mergeTwoLists(listNode.next, listNode1.next);
        System.out.println(listNode2);
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode currentListNode = new ListNode(0);

            mergeProcess(list1, list2, currentListNode);
            return currentListNode.next;
        }

        public void mergeProcess(ListNode list1, ListNode list2, ListNode currentListNode) {
            if (list1 == null && list2 == null) {
                return;
            }
            if (list1 == null) {
                currentListNode.next = list2;
                return;
            }
            if (list2 == null) {
                currentListNode.next = list1;
                return;
            }

            if (list1.val <= list2.val) {
                currentListNode.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                currentListNode.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            mergeProcess(list1, list2, currentListNode.next);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static ListNode buildListNode(ListNode listNode,int temp,int[] a){
        if (temp>=a.length){
            return listNode;
        }
        listNode.next = new ListNode(a[temp++]);
        buildListNode(listNode.next,temp,a);
        return listNode;
    }

}