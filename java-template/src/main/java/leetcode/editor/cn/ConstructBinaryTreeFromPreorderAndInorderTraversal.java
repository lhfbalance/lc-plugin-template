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
        
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            
            return buildTree(preorder, 0, preorder.length - 1, inorder, 0 ,inorder.length - 1);
        }

        private TreeNode buildTree(int[] preorder, int preorderBegin, int preorderEnd, int[] inorder, int inorderBegin, int inordeEnd) {

            if (preorderBegin > preorderEnd || inorderBegin > inordeEnd) {
                return null;
            }

            int rootIndexOfInorder = preorderBegin;
            for(int i = inorderBegin; i<=inordeEnd; i++) {
                if (inorder[i] == preorder[preorderBegin]) {
                    rootIndexOfInorder = i;
                }
            }

            int leftLength = rootIndexOfInorder - inorderBegin;
            int rightLength = inordeEnd - rootIndexOfInorder;


            TreeNode leftNode = buildTree(preorder, preorderBegin + 1, preorderBegin + leftLength, inorder, inorderBegin, rootIndexOfInorder - 1);
            TreeNode rightNode = buildTree(preorder, preorderBegin + leftLength + 1, preorderEnd, inorder, rootIndexOfInorder + 1, inordeEnd);

            TreeNode node = new TreeNode(inorder[rootIndexOfInorder], leftNode, rightNode);
            return node;

        }


    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        solution.buildTree(preorder, inorder);
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

