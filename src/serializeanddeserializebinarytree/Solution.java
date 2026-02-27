// LeetCode 297. Serialize and Deserialize Binary Tree
package serializeanddeserializebinarytree;

import basicdatastructure.TreeNode;
import java.util.LinkedList;

public class Solution {
    // separator
    String SEP = ",";
    // null node sign
    String NULL = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    // tool method, save binary tree into StringBuilder
    private void serialize(TreeNode root, StringBuilder sb) {
        // base case
        if (root == null) {
            sb.append(NULL).append(SEP);
        }

        // preorder position
        sb.append(root.val).append(SEP);

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // toole method(using postorder), save binary tree into StringBuilder
    private void serialize1(TreeNode root, StringBuilder sb) {
        // base case
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        serialize1(root.left, sb);
        serialize1(root.right, sb);
        
        // postorder position
        sb.append(root.val).append(SEP);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // transfer String into List
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    // tool method, construct binary tree from List
    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }

        // preorder position
        // The root node is the leftest of the nodes
        String first = nodes.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }

    // tool method(using postorder iteration), construct binary tree from List
    private TreeNode deserialize1(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }

        // The root node is the last element of the nodes
        String last = nodes.removeLast();
        if (last.equals(NULL)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(last));

        // deserialize right first.
        root.right = deserialize(nodes);
        root.left = deserialize(nodes);

        return root;
    }
}
