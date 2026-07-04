/*
 * @lc app=leetcode.cn id=654 lang=java
 * @lcpr version=30403
 *
 * [654] 最大二叉树
 */

package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class MaximumBinaryTree {

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
        public TreeNode constructMaximumBinaryTree(int[] nums) {

            return constructMaximumBinaryTree(nums, 0 ,nums.length - 1);
            
        }

        private TreeNode constructMaximumBinaryTree(int[] nums, int begin, int end) {

            if (begin > end) {
                return null;
            }

            int maxIndex = findMaxIndex(nums, begin, end);
            
            TreeNode left = constructMaximumBinaryTree(nums, begin, maxIndex - 1);
            TreeNode right = constructMaximumBinaryTree(nums, maxIndex + 1, end);

            TreeNode node = new TreeNode(nums[maxIndex]);
            node.left = left;
            node.right = right;

            return node;

        }

        private int findMaxIndex(int[] nums, int begin, int end) {
            int res = begin;
            int maxValue = nums[begin];
            for(int i = begin; i<= end ; i++) {
                if (nums[i] > maxValue) {
                    maxValue = nums[i];
                    res = i;
                }
            }
            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new MaximumBinaryTree().new Solution();
        int[] arr = {3,2,1,6,0,5};
        solution.constructMaximumBinaryTree(arr);
        // put your test code here

    }
}



/*
// @lcpr case=start
// [3,2,1,6,0,5]\n
// @lcpr case=end

// @lcpr case=start
// [3,2,1]\n
// @lcpr case=end

 */

