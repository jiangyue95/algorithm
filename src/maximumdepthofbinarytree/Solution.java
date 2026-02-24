// LeetCode 104. Maximum Depth of Binary Tree
package maximumdepthofbinarytree;

import basicdatastructure.TreeNode;

public class Solution {
    // 记录最大深度
    private static int maxDepth = 0;
    // 记录遍历到的节点的深度
    private static int depth = 0;

    public static int maxDepth(TreeNode root) {
        traverse(root);
        return maxDepth;
    }

    // 二叉树遍历框架
    private static void traverse(TreeNode root) {
        if (root == null) {
            // 到达叶子节点， 更新最大深度
            maxDepth = Math.max(maxDepth, depth);
            return;
        }

        // 前序位置
        depth++;
        traverse(root.left);
        traverse(root.right);
        // 后序位置
        depth--;
    }

    // 分解问题计算答案的思路
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth2(root.left);
        int rightMax = maxDepth2(root.right);
        int maxDepth = Math.max(leftMax, rightMax) + 1;
        return maxDepth;
    }

    public static void main(String[] args) {
        System.out.println("LeetCode 104. Maximum Depth of Binary Tree");
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println("Maximum Depth: " + maxDepth2(root));
    }
}
