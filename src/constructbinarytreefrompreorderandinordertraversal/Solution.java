// LeetCode 105. Construct Binary Tree from Preorder and Inorder Traversal
// Tags: Binary Tree
package constructbinarytreefrompreorderandinordertraversal;

import basicdatastructure.TreeNode;
import java.util.HashMap;

public class Solution {

    // Record the mapping of value to index in inorder
    // This HashMap is used to avoid loop search
    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    /**
     * Main method call the build method to construct the binary tree
     * @param preorder preorder traversal array
     * @param inorder inorder traversal array
     * @return the root node of the binary tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // initialize the inorder HashMap
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        // Based on the definition， use preorder and inorder sequencees construct binary tree
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * The definition of build
     * Assume that the preorder traversal array is preorder[preStart..preEnd],
     * the inorder traversal array is inorder[inStart..inEnd]
     * construct the binary tree, return the root node of this binary tree
     * @param preorder preorder traversal array
     * @param preStart the begin index of preorder traversal array
     * @param preEnd the end index of preorder traversal array
     * @param inorder inorder traversal array
     * @param inStart the begin index of inorder traversal array
     * @param inEnd the end index of inorder traversal array
     * @return the root node of this binary tree
     */
    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart,
            int inEnd) {
        // base case
        if (preStart > preEnd) {
            return null;
        }
        // The root node should be the first element of the preorder traversal array
        int rootVal = preorder[preStart];

        // Avoid for loop to search rootVal
        int index = valToIndex.get(rootVal);

        // Determine the length of the left subtree
        int leftSize = index - inStart;

        // Create the root node
        TreeNode root = new TreeNode(rootVal);

        // Recursively construct the left subtree and the right subtree
        // It is easy to determine the boundary of inorder traversal array
        // The key point is to determine the boundary of preorder traversal array
        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
        
        return root;
    }
}
