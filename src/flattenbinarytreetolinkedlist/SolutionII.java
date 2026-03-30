// LeetCode 114. Flatten Binary Tree into Linked List
// using the thought of iteration
// traverse the whole binart Tree, and construct a new linked list
//
// this solution does not meet the requirements of the problem
// based on the signature of the solution method,
// this problem wants us to solve this problem in-place
package flattenbinarytreetolinkedlist;

import basicdatastructure.TreeNode;

public class SolutionII {
    // virutal head node, dummy.right is the result
    TreeNode dummy = new TreeNode(-1);
    
    // the pointer is used to create the linked lust
    TreeNode p = dummy;

    public void traverse(TreeNode root) {
        // base case: the binary tree is null
        if (root == null) {
            return;
        }

        // pre-order traverse position
        p.right = new TreeNode(root.val);
        // the pointer p moves to next node
        p = p.right;

        traverse(root.left);
        traverse(root.right);
    }
    
}
