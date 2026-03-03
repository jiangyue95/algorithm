// LeetCode 98. Validate Binary Search Tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
package validatebinarysearchtree;

import basicdatastructure.TreeNode;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    // All nodes in subtree rooted at root must satisfy min.val < root.val < max.val
    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }

        // If the root.val didn't follow the limits of the max and min
		// it indicates this is not a BST
        if (min != null && root.val < min.val) {
            return false;
        }

        if (max != null && root.val > max.val) {
            return false;
        }

        // limit the max value of left subtree is root.val
		// and the min value of right subtree is root.val
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
