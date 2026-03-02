// LeetCode 538. Convert BST to Greater Tree
// LeetCode 1038 is same as LeetCode 538.
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
package convertbsttogreatertree;

import basicdatastructure.TreeNode;

public class Solution {

    // record accumulated value
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        // baseline case
        if (root == null) {
            return;
        }

        traverse(root.right);
        // inorder traversal position
        // accumulate the value
        sum += root.val;
        // convert BST into Greater Tree
        root.val = sum;
        traverse(root.left);
    }
}
