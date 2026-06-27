/*
 * @lc app=leetcode.cn id=230 lang=java
 * @lcpr version=30403
 *
 * [230] 二叉搜索树中第 K 小的元素
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class KthSmallestElementInABst {

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

        
        public int kthSmallest(TreeNode root, int k) {
            traverse(root, k);
            return res;
        }
        int res = 0;
        int rank = 0;
        void traverse(TreeNode root, int k) {
            if (root == null) {
                return;
            }
            
            traverse(root.left, k);
            rank ++ ;
            if (k == rank) {
                res = root.val;
                return;
            }

            traverse(root.right, k);
        }

    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInABst().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [3,1,4,null,2]\n1\n
// @lcpr case=end

// @lcpr case=start
// [5,3,6,2,4,null,null,1]\n3\n
// @lcpr case=end

 */

