package leetcode.editor.common;

public class ListNode {
    public int val;
    public ListNode next;


    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] ints) {
        ListNode head = new ListNode(0), current = head;
        for (int i = 1; i < ints.length; i++) {
            ListNode listNode = new ListNode(ints[i]);
            current.next = listNode;
            current = current.next;
        }
        val = ints[0];
        next = head.next;
    }
}
