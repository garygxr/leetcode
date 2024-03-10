//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2590 👎 0


package leetcode.editor.cn;

import leetcode.editor.common.TreeNode;

import java.util.LinkedList;

/**
 * 对称二叉树
 *
 * @author DY
 * @date 2023-11-15 16:03:10
 */
public class SymmetricTree_101 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SymmetricTree_101().new Solution();
        boolean symmetric = solution.isSymmetric(TreeNode.buildTree(1,2,2,3,4,4,3));
        System.out.println(symmetric);
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
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            //return dfs(root.left, root.right);
            return hfs(root);
        }

        boolean dfs(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            return dfs(left.left, right.right) && dfs(left.right, right.left);
        }

        boolean hfs(TreeNode treeNode) {
            if (treeNode.left == null && treeNode.right == null) {
                return true;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(treeNode.left);
            queue.add(treeNode.right);
            while (queue.size() > 0) {
                TreeNode left = queue.poll();
                TreeNode right = queue.poll();
                if (left == null && right == null) {
                    continue;
                }
                if (left == null || right == null) {
                    return false;
                }
                if (left.val != right.val) {
                    return false;
                }
                queue.add(left.left);
                queue.add(right.right);
                queue.add(left.right);
                queue.add(right.left);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}