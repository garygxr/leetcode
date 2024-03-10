//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 1878 👎 0


package leetcode.editor.cn;

import leetcode.editor.common.TreeNode;

import java.util.*;

/**
 * 二叉树的层序遍历
 *
 * @author DY
 * @date 2024-02-04 15:16:07
 */
public class BinaryTreeLevelOrderTraversal_102 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new BinaryTreeLevelOrderTraversal_102().new Solution();
        List<List<Integer>> lists = solution.levelOrder(TreeNode.buildTree(3, 9, 20, null, null, 15, 7));
        System.out.println(lists);
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            ArrayList<List<Integer>> lists = new ArrayList<>(32);
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                ArrayList<Integer> innerList = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    innerList.add(poll.val);
                    if (poll.left != null) {
                        queue.add(poll.left);
                    }
                    if (poll.right != null) {
                        queue.add(poll.right);
                    }
                }
                lists.add(innerList);
            }
            return lists;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}