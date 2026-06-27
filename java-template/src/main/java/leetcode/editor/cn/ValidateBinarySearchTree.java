/*
 * @lc app=leetcode.cn id=98 lang=java
 * @lcpr version=30403
 *
 * [98] 验证二叉搜索树
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ValidateBinarySearchTree {

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
        public boolean isValidBST(TreeNode root) {

            tranverse(root, null, null);
            return res;
            
        }
        boolean res = true;
        void tranverse(TreeNode root, TreeNode min, TreeNode max) {
            if (root == null) {
                return;
            }
            if (min != null && root.val <= min.val) {
                res = false;
                return;
            }
            tranverse(root.left, min, root);

            if (max != null && root.val >= max.val) {
                res = false;
                return;
            }
            tranverse(root.right, root, max);
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        // Solution solution = new ValidateBinarySearchTree().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [2,1,3]\n
// @lcpr case=end

// @lcpr case=start
// [5,1,4,null,null,3,6]\n
// @lcpr case=end

 */

