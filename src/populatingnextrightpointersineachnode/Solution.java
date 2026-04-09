// LeetCode 116. Populating Next Right Pointers in Each Node
// Tag: Binary Tree, Perfect Binary Tree
package populatingnextrightpointersineachnode;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Solution {

    public Node connect(Node root) {
        // base case
        if (root == null) {
            return null;
        }

        traverse(root.left, root.right);
        return root;
    }

    private void traverse(Node node1, Node node2) {
        // base case
        if (node1 == null || node2 == null) {
            return;
        }

        node1.next = node2;

        // left subtree
        traverse(node1.left, node1.right);

        // right subtree
        traverse(node2.left, node2.right);

        // left subtree and right subtree
        traverse(node1.right, node2.left);
    }
}
