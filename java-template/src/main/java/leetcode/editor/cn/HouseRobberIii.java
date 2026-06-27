/*
 * @lc app=leetcode.cn id=337 lang=java
 * @lcpr version=30403
 *
 * [337] 打家劫舍 III
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class HouseRobberIii {

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

        public int rob(TreeNode root) {
            int[] res = robed(root);
            return Math.max(res[0], res[1]);
        }
        int[] robed(TreeNode root) {
            int[] res = new int[2];
            if (root == null) {
                return res;
            }
            
            int[] subLeft = robed(root.left);
            int[] subRight = robed(root.right);
            // 抢
            res[0] = root.val + subLeft[1] + subRight[1];
            // 不抢, 下一层可抢，可不抢，取最大值
            res[1] = Math.max(subLeft[0], subLeft[1]) + Math.max(subRight[0], subRight[1]);
            return res;
        }

        Map<TreeNode, Integer> memo = new HashMap<>();
        public int rob1(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (memo.containsKey(root) ) {
                return memo.get(root);
            }
            // 抢
            int doit = root.val 
            + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
            + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
            // 不抢
            int notdoit = rob(root.left) + rob(root.right);
            int res = Math.max(doit, notdoit);
            memo.put(root, res);
            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new HouseRobberIii().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [3,2,3,null,3,null,1]\n
// @lcpr case=end

// @lcpr case=start
// [3,4,5,1,3,null,1]\n
// @lcpr case=end

 */

