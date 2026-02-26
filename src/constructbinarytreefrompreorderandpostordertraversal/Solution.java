// LeetCode 889. Construct Binary Tree from Preorder and Postorder Traversal
package constructbinarytreefrompreorderandpostordertraversal;

import basicdatastructure.TreeNode;
import java.util.HashMap;

public class Solution {
    // 存储 postorder 中值到索引的映射（map）
    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            valToIndex.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    /**
     * 定义： 根据 preorder[preStart..preEnd] 和 postorder[postStart, postEnd]
     * 构建二叉树，并返回根节点
     * @param preorder
     * @param preStart
     * @param preEnd
     * @param postorder
     * @param postStart
     * @param postEnd
     * @return
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

        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // root.left 的值前序遍历的第二个元素
        // 通过前序和后序遍历构造二叉树的关键在于通过左子树的根节点
        // 确定 preorder 和 postorder 中左右子树的元素区间
        int leftRootVal = preorder[preStart + 1];
        // leftRootVal 在后序遍历数组中的索引
        int index = valToIndex.get(leftRootVal);
        if (index == postEnd - 1) {
            // 无左子树，只有右子树
            root.right = build(preorder, preStart + 1, preEnd, postorder, postStart, postEnd - 1);
        } else {
            int leftSize = index - postStart + 1;
            // 递归构造左右子树
            root.left =
                    build(preorder, preStart + 1, preStart + leftSize, postorder, postStart, index);
            root.right = build(preorder, preStart + leftSize + 1, preEnd, postorder, index + 1,
                    postEnd - 1);

        }
        return root;
    }
}
