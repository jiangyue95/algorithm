package topic01_binary_tree_and_bst.leetcode654_maximum_binary_tree;

import basicdatastructure.TreeNode;

/**
 * LeetCode 654. Maximum Binary Tree
 * 
 * Tags: Binary Tree, Construction & Serialization
 */

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int lo, int hi) {
        // base case
        if (lo > hi) {
            return null;
        }

        // find the biggest value and its index
        int index = -1;
        int maxVal = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (maxVal < nums[i]) {
                index = i;
                maxVal = nums[i];
            }
        }

        // create root node
        TreeNode root = new TreeNode(maxVal);

        // call build recursively to build left and right subtree
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);

        return root;
    }
}
