/*
 * @lc app=leetcode.cn id=226 lang=java
 * @lcpr version=30403
 *
 * [226] 翻转二叉树
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class InvertBinaryTree {

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

        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            // 交换左右子树
            root.right = left;
            root.left = right;
            return root;
        }

        public TreeNode invertTree1(TreeNode root) {
            travese(root);
            return root;
        }

        public void travese(TreeNode root) {
            if (root == null) {
                return;
            }

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            travese(root.left);
            travese(root.right);
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [4,2,7,1,3,6,9]\n
// @lcpr case=end

// @lcpr case=start
// [2,1,3]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */

