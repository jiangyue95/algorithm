// LeetCode 114. Flatten Binary Tree to Linked List
// use the thought of break down problem

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
package flattenbinarytreetolinkedlist;

import basicdatastructure.TreeNode;

public class Solution {
	// definition: transfer the binary tree with the root is the root node
	// into a linked list
	// and its order is pre-order travers
    public void flatten(TreeNode root) {
        // base case: the binary tree is null
		if (root == null) {
			return;
		}

		// base on the definition of method flatten
		// flatten the left and right subtree
		flatten(root.left);
		flatten(root.right);

		// post-order position
		// store the new linke list 
		// flatten base on the original left and tigth subtree
		TreeNode left = root.left;
		TreeNode right = root.right;

		// transfer the left subtree in the root.right
		root.left = null;
		root.right = left;

		// add original right subtree to the end of current right subtree
		TreeNode p = root;
		// find the end of curent root.right
		while (p.right != null) {
			p = p.right;
		}
		
		p.right = right;
    }
}