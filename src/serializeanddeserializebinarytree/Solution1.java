// LeetCode 297. Serialize and Deserialize Binary Tree
package serializeanddeserializebinarytree;

import basicdatastructure.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    String SEP = ",";
    String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        // Init queue and add root 
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                // 层次遍历代码位置
                if (cur == null) {
                    sb.append(NULL).append(SEP);
                    continue;
                }
                sb.append(cur.val).append(SEP);

                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String[] nodes = data.split(SEP);
        // The first value is the root value.
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        // The q records parent node, add root into q.
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // The index records the position in q of serialized node.
        int index = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode parent = q.poll();

                // The value in the left of parent node
                String left = nodes[index++];
                if (!left.equals(NULL)) {
                    parent.left = new TreeNode(Integer.parseInt(left));
                    q.offer(parent.left);
                }

                // The value in the right of parent node
                String right = nodes[index++];
                if (!right.equals(NULL)) {
                    parent.right = new TreeNode(Integer.parseInt(right));
                    q.offer(parent.right);
                }
            }
        }
        return root;
    }
}
