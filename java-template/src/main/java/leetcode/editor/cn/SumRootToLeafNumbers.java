/*
 * @lc app=leetcode.cn id=129 lang=java
 * @lcpr version=30403
 *
 * [129] 求根节点到叶节点数字之和
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SumRootToLeafNumbers {

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
        public int sumNumbers(TreeNode root) {
            tranverse(root);
            int result = 0;
            for(String s : res) {
                result += Integer.valueOf(s);
            }
            return result;
            
        }

        List<String> path = new LinkedList<>();
        List<String> res = new LinkedList<>();
        void tranverse(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                path.addLast(String.valueOf(root.val));
                res.add(String.join("", path));
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
        Solution solution = new SumRootToLeafNumbers().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [4,9,0,5,1]\n
// @lcpr case=end

 */

