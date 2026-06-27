/*
 * @lc app=leetcode.cn id=701 lang=java
 * @lcpr version=30403
 *
 * [701] 二叉搜索树中的插入操作
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class InsertIntoABinarySearchTree {

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
        public TreeNode insertIntoBST(TreeNode root, int val) {

            if (root == null) {
                return new TreeNode(val);
            }
            if (root.val > val) {
                // 要对返回值进行接收，和找不一样的地方
                root.left = insertIntoBST(root.left, val);
            } else {
                // 要对返回值进行接收，和找不一样的地方
                root.right = insertIntoBST(root.right, val);
            }
            return root;
            
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new InsertIntoABinarySearchTree().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [4,2,7,1,3]\n5\n
// @lcpr case=end

// @lcpr case=start
// [40,20,60,10,30,50,70]\n25\n
// @lcpr case=end

// @lcpr case=start
// [4,2,7,1,3,null,null,null,null,null,null]\n5\n
// @lcpr case=end

 */

