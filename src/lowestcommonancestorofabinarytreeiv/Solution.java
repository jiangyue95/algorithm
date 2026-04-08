// LeetCode 1676. Lowest Common Ancestor of a Binary Tree IV
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
package lowestcommonancestorofabinarytreeiv;

import basicdatastructure.TreeNode;
import java.util.HashSet;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        // transfer the array into HashSet, in order to check if the elements exist
        HashSet<Integer> values = new HashSet<>();
        for (TreeNode node : nodes) {
            values.add(node.val);
        }

        return find(root, values);
    }

    // serach the LCA of values in a binary tree
    private TreeNode find(TreeNode root, HashSet<Integer> values) {
        if (root == null) {
            return null;
        }

        // preorder position
        if (values.contains(root.val)) {
            return root;
        }

        TreeNode left = find(root.left, values);
        TreeNode right = find(root.right, values);

        // postorder position
        if (left != null && right != null) {
            // current node is LCA
            return root;
        }

        return left != null ? left : right;
    }
}
