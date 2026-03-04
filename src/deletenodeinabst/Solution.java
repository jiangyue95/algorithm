// LeetCode 450. Delete Node in a BST
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
package deletenodeinabst;

import basicdatastructure.TreeNode;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        // base case
        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            // find target node, begain delete
            if (root.left == null) {
                return root.right; // no left child node
            } else if (root.right == null) {
                return root.left; // no right child node
            } else {
                // two child nodes
                TreeNode successor = getMin(root);
                root.val = successor.val;
                root.right = deleteNode(root.right, successor.val);
            }
        }
        return root;
    }

    private TreeNode getMin(TreeNode node) {
        // The leftest node is the smallest node in a BST
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
