// LeetCode 1644. Lowest Common Ancestor of a Binary Tree II (Locked)
package lowestcommonancestorofabinarytreeii;

import basicdatastructure.TreeNode;

public class Solution {

    private boolean foundP = false;
    private boolean foundQ = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = find(root, p.val, q.val);
        if (!foundP || !foundQ) {
            return null;
        }

        // Only the p and q exist in root, there is a ancestor
        return res;
    }

    private TreeNode find(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }

        TreeNode left = find(root.left, val1, val2);
        TreeNode right = find(root.right, val1, val2);

        // postorder position
        if (left != null && right != null) {
            return root;
        }

        // postorder position
        if (root.val == val1 || root.val == val2) {
            if (root.val == val1) {
                foundP = true;
            }
            if (root.val == val2) {
                foundQ = true;
            }
            return root;
        }

        return left != null ? left : right;
    }
}
