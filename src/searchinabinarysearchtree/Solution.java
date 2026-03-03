// LeetCode 700. Search in a Binary Search Tree
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
package searchinabinarysearchtree;

import basicdatastructure.TreeNode;

public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        // base case
        if (root == null) {
            return null;
        }

        // search in left subtree
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        // search in right subtree
        if (root.val < val) {
            return searchBST(root.right, val);
        }

        return root;
    }
}
