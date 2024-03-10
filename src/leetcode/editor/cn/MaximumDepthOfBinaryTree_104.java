//给定一个二叉树 root ，返回其最大深度。 
//
// 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：root = [1,null,2]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量在 [0, 10⁴] 区间内。 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1775 👎 0


package leetcode.editor.cn;

import leetcode.editor.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 二叉树的最大深度
 *
 * @author DY
 * @date 2024-02-04 14:39:37
 */
public class MaximumDepthOfBinaryTree_104 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new MaximumDepthOfBinaryTree_104().new Solution();
        TreeNode treeNode = TreeNode.buildTree(3, 9, 20, null, null, 15, 7);
        int i = solution.maxDepth(treeNode);
        System.out.println(i);
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
        public int maxDepth(TreeNode root) {
            return method02(root);
        }

        private int method01(TreeNode root) {
            if (root == null) return 0;
            return Math.max(method01(root.left), method01(root.right)) + 1;
        }

        private int method02(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new ArrayDeque<>(3);
            queue.add(root);
            int a = 0;
            while (!queue.isEmpty()) {
                a++;
                int deep = queue.size();
                for (int i = 0; i < deep; i++) {
                    TreeNode pop = queue.poll();
                    if (pop.left != null) {
                        queue.add(pop.left);
                    }
                    if (pop.right != null) {
                        queue.add(pop.right);
                    }
                }
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}