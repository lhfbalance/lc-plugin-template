/*
 * @lc app=leetcode.cn id=257 lang=java
 * @lcpr version=30403
 *
 * [257] 二叉树的所有路径
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class BinaryTreePaths {

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
        public List<String> binaryTreePaths(TreeNode root) {
            tranverse(root);
            return res;
        }
        List<String> path = new LinkedList<>();
        List<String> res = new LinkedList<>();
        void tranverse(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                path.addLast(String.valueOf(root.val));
                res.add(String.join("->", path));
                path.removeLast();
            }

            path.addLast(String.valueOf(root.val));
            tranverse(root.left);
            tranverse(root.right);
            path.removeLast();
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,2,3,null,5]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

