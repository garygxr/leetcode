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

    public ListNode(int... ints) {
        ListNode listNode = buildListNode(new ListNode(0), 0, ints);
        this.val = listNode.val;
        this.next = listNode.next;
    }

    public static ListNode buildListNode(ListNode listNode, int temp, int... a) {
        if (temp >= a.length) {
            return listNode;
        }
        listNode.next = new ListNode(a[temp++]);
        buildListNode(listNode.next, temp, a);
        return listNode.next;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(val);
        ListNode tempNode = new ListNode(val, next);
        while (tempNode.next != null) {
            stringBuilder.append("->").append(tempNode.next.val);
            tempNode = tempNode.next;
        }
        return stringBuilder.toString();
    }
}
