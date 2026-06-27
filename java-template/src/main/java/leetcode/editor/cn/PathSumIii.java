/*
 * @lc app=leetcode.cn id=437 lang=java
 * @lcpr version=30403
 *
 * [437] 路径总和 III
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class PathSumIii {

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
        private long pathSum = 0;
        private int res = 0;
        private Map<Long, Integer> preSum = new HashMap<>();

        public int pathSum(TreeNode root, int targetSum) {
            // 题目中说路径只能向下，什么时候应该，去掉最上面的节点，什么时候应该向下走呢
            // 节点的值有可能是负数，好像没办法用类似的滑动窗口
            // 用前缀和技巧，把二叉树的路径看作是一个动态的数组
            // 前序位置判断是否满足 targetSum。
            // 前序位置添加前缀和，后续去掉前缀和。
            preSum.put(0L, 1);
            traverse(root, targetSum);
            return res;
            
        }

        public void traverse(TreeNode root, int targetSum) {
            if (root == null) {
                return;
            }

            pathSum += root.val;
            res += preSum.getOrDefault(pathSum - targetSum, 0);

            
            preSum.put(pathSum, preSum.getOrDefault(pathSum, 0) + 1);

            traverse(root.left, targetSum);
            traverse(root.right, targetSum);
            
            // 后续位置撤销当前前缀和的数量
            preSum.put(pathSum, preSum.getOrDefault(pathSum, 0) - 1);
            // 后续位置回退 pathsum
            pathSum -= root.val;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
        
        // put your test code here

    }
}



/*
// @lcpr case=start
// [10,5,-3,3,2,null,11,3,-2,null,1]\n8\n
// @lcpr case=end

// @lcpr case=start
// [5,4,8,11,null,13,4,7,2,null,null,5,1]\n22\n
// @lcpr case=end

 */

