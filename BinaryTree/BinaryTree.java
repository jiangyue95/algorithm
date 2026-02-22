import java.util.List;
import java.util.ArrayList;

public class BinaryTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        System.out.println("前序遍历: " + preorderTraversal(node1));
        System.out.println("中序遍历: " + inorderTraversal(node1));
        System.out.println("后序遍历: " + postorderTraversal(node1));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private static void preorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        result.add(root.val);

        preorder(root.left, result);
        preorder(root.right, result);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private static void inorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }
    
    private static void postorder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }
}