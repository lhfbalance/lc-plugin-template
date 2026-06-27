/*
 * @lc app=leetcode.cn id=105 lang=java
 * @lcpr version=30403
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    // @lc code=start
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            
            for(int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            
            return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            if (inStart > inEnd) {
                // base case
                return null;
            }
            int rootValue = preorder[preStart];
            // 前序遍历的第一个元素是根节点
            TreeNode root = new TreeNode(rootValue);
            // 找到根节点在中序遍历中的位置
            int rootIndex = map.get(rootValue);
            // 获取左子树的长度
            int leftLength = rootIndex - inStart;
            // 构建左子树
            TreeNode left = build(preorder, preStart + 1, preStart + leftLength, inorder, inStart, rootIndex - 1);
            // 构建右子树
            TreeNode right = build(preorder, preStart + leftLength + 1, preEnd, inorder, rootIndex + 1, inEnd);
            root.left = left;
            root.right = right;
            return root;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [3,9,20,15,7]\n[9,3,15,20,7]\n
// @lcpr case=end

// @lcpr case=start
// [-1]\n[-1]\n
// @lcpr case=end

 */

