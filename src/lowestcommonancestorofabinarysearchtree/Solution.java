// LeetCode 235. Lowest Common Ancestor of a Binary Search Tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

package lowestcommonancestorofabinarysearchtree;

import basicdatastructure.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // guarantee the val1 is smaller, and val2 is bigger
        int val1 = Math.min(p.val, q.val);
        int val2 = Math.max(p.val, q.val);
        return find(root, val1, val2);
    }

    // search the LCA of val1 and val2 in the BST
    private TreeNode find(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }

        if (root.val > val2) {
            // current node is too big, search in the left subtree
            return find(root.left, val1, val2);
        }

        if (root.val < val1) {
            // current node it too small, search in the right subtree
            return find(root.right, val1, val2);
        }

        // val1 <= root.val < val2
        // current node is the LCA
        return root;
    }
}
