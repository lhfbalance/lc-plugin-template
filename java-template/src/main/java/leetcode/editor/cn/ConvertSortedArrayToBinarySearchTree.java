/*
 * @lc app=leetcode.cn id=108 lang=java
 * @lcpr version=30403
 *
 * [108] 将有序数组转换为二叉搜索树
 */

package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class ConvertSortedArrayToBinarySearchTree {

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
        public TreeNode sortedArrayToBST(int[] nums) {
            return buildTree(nums, 0, nums.length - 1);
        }

        TreeNode buildTree(int[] nums, int begin, int end) {
            if (begin > end) {
                return null;
            }

            int mid = begin + (end - begin) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = buildTree(nums, begin, mid - 1);
            root.right = buildTree(nums, mid + 1, end);
            return root;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [-10,-3,0,5,9]\n
// @lcpr case=end

// @lcpr case=start
// [1,3]\n
// @lcpr case=end

 */

