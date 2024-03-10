//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 2215 👎 0


package leetcode.editor.cn;

import leetcode.editor.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 验证二叉搜索树
 *
 * @author DY
 * @date 2023-11-15 11:06:47
 */
public class ValidateBinarySearchTree_98 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ValidateBinarySearchTree_98().new Solution();
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{-2147483648});

        boolean validBST = solution.isValidBST(treeNode);
        System.out.println(validBST);
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
        public boolean isValidBST(TreeNode root) {
            //return extracted(root, null, null);
            return extracted2(root);
        }

        private boolean extracted2(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<TreeNode>();
            Integer inorder = null;

            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
                if (inorder != null && root.val <= inorder) {
                    return false;
                }
                inorder = root.val;
                root = root.right;
            }
            return true;
        }

        private boolean extracted(TreeNode root, Integer lower, Integer upper) {
            if (root == null) {
                return true;
            }
            if ((lower != null && root.val <= lower) || (upper != null && root.val >= upper)) {
                return false;
            }
            return extracted(root.left, lower, root.val) && extracted(root.right, root.val, upper);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}