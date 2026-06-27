/*
 * @lc app=leetcode.cn id=543 lang=java
 * @lcpr version=30403
 *
 * [543] 二叉树的直径
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class DiameterOfBinaryTree {

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
        public int diameterOfBinaryTree(TreeNode root) {
            // root 为
            maxDepth(root);

            return res;
        }

        int res = 0;
        // root为根，树的最大深度
        int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            //
            res = Math.max(res, leftDepth + rightDepth);
            // 取左右子树的最大深度加上自己
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,2,3,4,5]\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n
// @lcpr case=end

 */

