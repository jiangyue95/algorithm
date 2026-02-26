// LeetCode 105. Construct Binary Tree from Preorder and Inorder Traversal
package constructbinarytreefrompreorderandinordertraversal;

import basicdatastructure.TreeNode;
import java.util.HashMap;

public class Solution {
    // 存储 inorder 中值到索引的映射
    HashMap<Integer, Integer> valToIndex = new HashMap<>();
    // 主函数
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 初始化 inorder HashMap
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        // 根据函数定义，用 preorder 和 inorder 构造二叉树
        return build(preorder, 0, preorder.length - 1, inorder, 0, preorder.length - 1);
    }

    /**
     * build 函数的定义
     * 假设前序遍历数组为 preorder[preStart..preEnd]
     * 中序遍历数组为 inorder[inStart..inEnd]
     * 构造二叉树，返回该二叉树的根节点
     */
    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart,
            int inEnd) {
        // base case
        if (preStart > preEnd) {
            return null;
        }
        // root 节点对应的就是前序遍历数组中的第一个元素
        int rootVal = preorder[preStart];
        // rootVal 是中序遍历数组中的索引
        // 通过 for 循环便利的方式去确定 index 的效率不高，可以进一步优化
        // int index = 0;
        // for (int i = inStart; i < inEnd; i++) {
        //     if (inorder[i] == rootVal) {
        //         index = i;
        //         break;
        //     }
        // }

        // 避免 for 循环寻找 rootVal
        int index = valToIndex.get(rootVal);

        // 确定左子树的长度
        int leftSize = index - inStart;

        // 创建根节点
        TreeNode root = new TreeNode(rootVal);

        // 递归构造左右子树，中序遍历数组的边界好写，重点是前序遍历数组的边界
        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
        
        return root;
    }
}
