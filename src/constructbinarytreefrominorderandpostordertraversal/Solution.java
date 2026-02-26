// LeetCode 106. Construct Binary Tree from Inorder and Postorder Traversal
package constructbinarytreefrominorderandpostordertraversal;

import basicdatastructure.TreeNode;
import java.util.HashMap;

public class Solution {
    // 储存 inorder 中值到索引的映射（map）
    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    // 主函数
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }

        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    /**
     * build 函数的定义
     * 后序遍历数组为 postorder[postStart..postEnd]，
     * 中序遍历数组为 inorder[inStart..inEnd]，
     * 构造二叉树，返回该二叉树的根节点
     * @param inorder中序遍历数组
     * @param inStart中序遍历数组起始索引
     * @param inEnd中序遍历数组结束索引
     * @param postorder后序遍历数组
     * @param postStart后序遍历数组起始索引
     * @param postEnd后序遍历数组结束索引
     * @return返回二叉树的根节点
     */
    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart,
            int postEnd) {
        // base case
        if (inStart > inEnd) {
            return null;
        }

        // root 节点对应的值就是后序遍历数组的最后一个元素
        int rootVal = postorder[postEnd];

        // rootVal 在中序遍历数组中的索引
        int index = valToIndex.get(rootVal);

        // 左子树个数
        int leftSize = index - inStart;

        // 构造根节点
        TreeNode root = new TreeNode(rootVal);

        // 递归构造左右子树
        root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);

        return root;

    }
}
