// LeetCode 230. Kth Smallest Element in a BST
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
package kthsmallestelementinabinarytree;

import basicdatastructure.TreeNode;

public class Solution {

    // store the result
    private int res;
    // record the rank of current element
    private int rank = 0;

    public int kthSmallest(TreeNode root, int k) {
        // utilize the property of inorder traversal in the BST
        traverse(root, k);
        return res;
    }

    private void traverse(TreeNode root, int k) {
        // baseline case
        if (root == null) {
            return;
        }

        traverse(root.left, k);
        // inorder traversal position
        rank++;
        if (k == rank) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
