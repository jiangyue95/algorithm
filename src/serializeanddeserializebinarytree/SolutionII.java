// LeetCode 297. Serialize and Deserialize Binary Tree
// Tags: Binary Tree
// Use postorder traversal
package serializeanddeserializebinarytree;

import basicdatastructure.TreeNode;
import java.util.LinkedList;

public class SolutionII {
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

    // toole method(using postorder), save binary tree into StringBuilder
    private void serialize(TreeNode root, StringBuilder sb) {
        // base case
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        serialize(root.left, sb);
        serialize(root.right, sb);
        
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

    // tool method(using postorder traversal), construct binary tree from List
    private TreeNode deserialize(LinkedList<String> nodes) {
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
