package leetcode.editor.common;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author gan
 * @Date 2023/11/14 18:55
 **/


public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public static TreeNode buildTree(Integer num) {
        if (num == 0) {
            return null;
        }
        Random random = new Random();
        TreeNode rootTreeNode = new TreeNode(random.nextInt(10));
        TreeNode tempRootTreeNode = rootTreeNode;
        for (int l = 0; l < num - 1; l++) {
            if (random.nextInt() % 2 == 0) {
                tempRootTreeNode.right = new TreeNode(random.nextInt(10));
                tempRootTreeNode = tempRootTreeNode.right;
            } else {
                tempRootTreeNode.left = new TreeNode(random.nextInt(10));
                tempRootTreeNode = tempRootTreeNode.left;
            }
        }
        return rootTreeNode;
    }

    public static TreeNode buildTree(Integer... nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < nums.length) {
            TreeNode current = queue.poll();

            // Add left child
            if (nums[i] != null) {
                current.left = new TreeNode(nums[i]);
                queue.add(current.left);
            }
            i++;

            if (i < nums.length) {
                if (nums[i] != null) {
                    // Add right child
                    current.right = new TreeNode(nums[i]);
                    queue.add(current.right);
                }
                i++;
            }
        }

        return root;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


}
