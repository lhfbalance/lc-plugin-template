/*
 * @lc app=leetcode.cn id=1022 lang=java
 * @lcpr version=30403
 *
 * [1022] 从根到叶的二进制数之和
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SumOfRootToLeafBinaryNumbers {

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
        public int sumRootToLeaf(TreeNode root) {
            tranverse(root);
            return res;
        }
        int path;
        int res;
        void tranverse(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                //增加 path, 二进制左移
                path = (path << 1) + root.val;

                res = res + path ;
                // 恢复 path
                path = path >> 1;
                return;
            }

            //前序增加 path, 二进制左移
            path = (path << 1) + root.val;
            tranverse(root.left);
            tranverse(root.right);
            // 后续恢复 path
            path = path >> 1;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new SumOfRootToLeafBinaryNumbers().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,0,1,0,1,0,1]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

 */

