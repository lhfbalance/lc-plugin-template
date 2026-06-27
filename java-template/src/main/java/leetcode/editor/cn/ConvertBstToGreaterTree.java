/*
 * @lc app=leetcode.cn id=538 lang=java
 * @lcpr version=30403
 *
 * [538] 把二叉搜索树转换为累加树
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ConvertBstToGreaterTree {

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

        int sum = 0;
        public TreeNode convertBST(TreeNode root) {

            traverse(root);
            return root;
            
        }

        void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            
            convertBST(root.right);
            sum = root.val + sum;
            root.val = sum;
            convertBST(root.left);
            
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new ConvertBstToGreaterTree().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]\n
// @lcpr case=end

// @lcpr case=start
// [0,null,1]\n
// @lcpr case=end

 */

