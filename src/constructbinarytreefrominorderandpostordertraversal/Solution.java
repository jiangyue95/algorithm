// LeetCode 106. Construct Binary Tree from Inorder and Postorder Traversal
// Tags: Binary Tree
package constructbinarytreefrominorderandpostordertraversal;

import basicdatastructure.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    // Store the mapping from value to index in inorder traversal array
    Map<Integer, Integer> valToIndex = new HashMap<>();

    /**
     * main method call the build method to construct the binary tree
     * @param inorder inorder traversal array
     * @param postorder postorder traversal array
     * @return the root node of the binary tree constructed by the build method
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        // put the value into the hashmap
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }

        // call the build method
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    /**
     * Construct the binary tree 
     * definied by the inorder traversal array and the postorder traversal array
     * Return the root node of the binary tree
     * two key definition: inorder[inStart..inEnd], postorder[postStart..postEnd]
     * Assume that the inorder traversal array inorder begain with inStart and end with inEnd
     * and the postorder traversal array postorder begin with postStart and end with postEnd
     * @param inorder inorder traversal array
     * @param inStart the begin index of the inorder traversal array
     * @param inEnd the end index of the inorder traversal array
     * @param postorder postorder traversal array
     * @param postStart the begin index of the postorder traversal array
     * @param postEnd the end index of the postorder traversal array
     * @return the root node the constructed binary tree
     */
    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart,
            int postEnd) {
        // base case
        if (inStart > inEnd) {
            return null;
        }

        // the value the root node is the last element of postorder traversal array
        int rootVal = postorder[postEnd];

        // find the index in the inorder traversal array
        int index = valToIndex.get(rootVal);

        // calculate the count of the left subtree
        int leftSize = index - inStart;

        // Construct the root node
        TreeNode root = new TreeNode(rootVal);

        // Recursively construct the left subtree and right sub tree
        root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);

        return root;
    }
}
