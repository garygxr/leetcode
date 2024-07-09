//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
// targetSum 。如果存在，返回 true ；否则，返回 false 。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//输出：true
//解释：等于目标和的根节点到叶节点路径如上图所示。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,3], targetSum = 5
//输出：false
//解释：树中存在两条根节点到叶子节点的路径：
//(1 --> 2): 和为 3
//(1 --> 3): 和为 4
//不存在 sum = 5 的根节点到叶子节点的路径。 
//
// 示例 3： 
//
// 
//输入：root = [], targetSum = 0
//输出：false
//解释：由于树是空的，所以不存在根节点到叶子节点的路径。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1323 👎 0


package leetcode.editor.cn;

import leetcode.editor.common.TreeNode;

/**
 * 路径总和
 *
 * @author DY
 * @date 2024-03-10 13:13:28
 */
public class PathSum_112 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PathSum_112().new Solution();
        TreeNode treeNode = TreeNode.buildTree(1, 2);

        boolean b = solution.hasPathSum(treeNode, 1);
        System.out.println(b);
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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            return process(root, targetSum, 0);
        }

        public boolean process(TreeNode root, int targetSum, int currentSum) {
            if (root == null) {
                if (currentSum == targetSum) {
                    return true;
                } else {
                    return false;
                }

            }
            boolean process = process(root.left, targetSum, currentSum + root.val);
            if (process && root.right == null) {
                return process;
            }
            boolean process1 = process(root.right, targetSum, currentSum + root.val);
            return process&&process1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}