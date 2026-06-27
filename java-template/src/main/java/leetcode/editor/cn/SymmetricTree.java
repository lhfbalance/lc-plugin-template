/*
 * @lc app=leetcode.cn id=101 lang=java
 * @lcpr version=30403
 *
 * [101] 对称二叉树
 */

package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class SymmetricTree {

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

        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            } else {
                return isSame(root.left, root.right);
            }
        }

        boolean isSame(TreeNode left, TreeNode right) {
            if (left == null || right == null) {
                return left == right;
            }

            // 两棵树是否对称，首先是根节点相等，其次是左右子树对称
            return left.val == right.val && isSame(left.left, right.right) && isSame(left.right, right.left);
        }

        // Time Limit Exceeded
        public boolean isSymmetric1(TreeNode root) {
            traverse(root);
            int left = 0;
            int right = preOrder.size() - 1;
            while (left <= right) {
                if (!Objects.equals(preOrder.get(0), preOrder.get(right))) {
                    return false;
                }
            }
            return true;
            
        }
        List<Integer> preOrder = new LinkedList<>();
        void traverse(TreeNode root) {
            if (root == null) {
                preOrder.add(null);
                return;
            }
            traverse(root.left);
            preOrder.add(root.val);
            traverse(root.right);

        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,2,2,3,4,4,3]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,2,null,3,null,3]\n
// @lcpr case=end

 */

