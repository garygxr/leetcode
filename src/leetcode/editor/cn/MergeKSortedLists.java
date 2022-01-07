package leetcode.editor.cn;

//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 1677 👎 0

import leetcode.editor.common.ListNode;

public class MergeKSortedLists{
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        ListNode listNode = new ListNode(new int[]{1, 2, 3, 4});
        ListNode listNode2 = new ListNode(new int[]{ 2, 6, 7});
        ListNode listNode1 = solution.mergeKLists(new ListNode[]{listNode, listNode2});
        System.out.println(listNode1);
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode list = lists[1];
        for (int i = 1; i < lists.length; i++) {
            list = mergerListNode(list, lists[i]);
        }
        return list;
    }

    public ListNode mergerListNode(ListNode oneListNode,ListNode twoListNode){
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (oneListNode!=null&&twoListNode!=null){
            int val = oneListNode.val;
            int val1 = twoListNode.val;
            if (val<val1){
                tail.next = oneListNode;
                oneListNode = oneListNode.next;
            }else {
                tail.next = twoListNode;
                twoListNode = twoListNode.next;
            }
            tail = tail.next;
        }
        tail.next = (oneListNode!=null?oneListNode:twoListNode);
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}