// LeetCode 226. Invert Binary Tree
package invertbinarytree;

import basicdatastructure.TreeNode;

public class Solution {
    // 使用遍历的思维模式
    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        traverse(root.left);
        traverse(root.right);
    }

    // 使用“分解问题”的思维模式
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree1(root.left);
        TreeNode right = invertTree1(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
