//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1969 👎 0


package leetcode.editor.cn;


import leetcode.editor.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 *
 * @author DY
 * @date 2023-11-14 18:51:33
 */
public class BinaryTreeInorderTraversal_94 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new BinaryTreeInorderTraversal_94().new Solution();
        TreeNode treeNode = TreeNode.buildTree(0);
        System.out.println(treeNode);
        List<Integer> integers = solution.inorderTraversal(treeNode);
        System.out.println(integers);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            process(list, root);
            return list;
        }

        public void process(List<Integer> list, TreeNode node) {
            if (node==null){
                return;
            }
            TreeNode left = node.left;
            if (left != null) {
                process(list, left);
            }
            int val = node.val;
            list.add(val);
            TreeNode right = node.right;
            if (right != null) {
                process(list, right);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}