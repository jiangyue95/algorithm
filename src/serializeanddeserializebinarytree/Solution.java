// LeetCode 297. Serialize and Deserialize Binary Tree
// Tags: Binary Tree
// Use preorder traversal
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
            sb.append(NULL).append(SEP); // "#" 表示空节点
            return;
        }

        // preorder traversal position
        // 前序遍历位置
        sb.append(root.val).append(SEP); // 先根节点

        serialize(root.left, sb); // 再左子树
        serialize(root.right, sb); // 最后右子树
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
}
