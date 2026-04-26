// LeetCode 889. Construct Binary Tree from Preorder and Postorder Traversal
// Tags: Binary Tree
package constructbinarytreefrompreorderandpostordertraversal;

import basicdatastructure.TreeNode;
import java.util.HashMap;

public class Solution {

    // Store the mapping from vlaue to index in postorder traversal array
    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    /**
     * Main method calls the build method construct the binary tree
     * @param preorder preorder traversal array
     * @param postorder postorder traversal array
     * @return the root node of the binary tree
     */
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            valToIndex.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    /**
     * Based on preorder[preStart..preEnd] and postorder[postStart, postEnd]
     * Construct binary and return the root node
     * @param preorder the preorder traversal array
     * @param preStart the start index of the preorder traversal array
     * @param preEnd the end index of the preorder traversal array
     * @param postorder the postorder traversal array
     * @param postStart the start index of the postorder traversal array
     * @param postEnd the end index of the postorder traversal array
     * @return the root node of the binary tree
     */
    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart,
            int postEnd) {
        // base case
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        // the value of the root node is the first element of the preorder traversal array
        int rootVal = preorder[preStart];

        // Create the root node
        TreeNode root = new TreeNode(rootVal);

        // The value of node root.left is the second element of the preorder traversal array
        // The key of constructing binary tree by preorder traversal array and postorder traversal
        // array is determing the interval of left and right subtree by the preorder traversal and
        // the postorder interval.
        int leftRootVal = preorder[preStart + 1];
        
        // The index of the root.left's value in postorder traversal array
        int index = valToIndex.get(leftRootVal);
        if (index == postEnd - 1) {
            // There is no left subtree, only the right subtree
            root.right = build(preorder, preStart + 1, preEnd, postorder, postStart, postEnd - 1);
        } else {
            int leftSize = index - postStart + 1;
            // Recursively call build method to construct the left and right subree
            root.left =
                    build(preorder, preStart + 1, preStart + leftSize, postorder, postStart, index);
            root.right = build(preorder, preStart + leftSize + 1, preEnd, postorder, index + 1,
                    postEnd - 1);

        }
        return root;
    }
}
