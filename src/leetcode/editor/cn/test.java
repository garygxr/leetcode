package leetcode.editor.cn;

import leetcode.editor.common.ListNode;

/**
 * @Author garygan
 * @Date 2022/8/15 0015 9:17
 * @Description
 */
public class test {
    public static void main(String[] args) {
        ListNode listNode1 = Service.LIST_NODE1;
        Class<? extends ListNode> aClass = listNode1.getClass();
        String name = listNode1.getClass().getName();
        System.out.println(name);
    }


}
