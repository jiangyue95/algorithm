// LeetCode 226. Invert Binary Tree
// using the thought of seperate prolems
package invertbinarytree;

import basicdatastructure.TreeNode;

public class SolutionII {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
