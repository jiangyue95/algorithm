// LeetCode 236. Lowest Common Ancestor of a Binary Tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
package lowestcommonancestorofabinarytree;

import basicdatastructure.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p.val, q.val);
    }

    private TreeNode find(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }

        // preorder position
        if (root.val == val1 || root.val == val2) {
            // if it finds the target node, directly return
            return root;
        }

        TreeNode left = find(root.left, val1, val2);
        TreeNode right = find(root.right, val1, val2);

        // postorder position
        if (left != null && right != null) {
            // current node is the LCA node
            return root;
        }

        return left != null ? left : right;
    }
}
