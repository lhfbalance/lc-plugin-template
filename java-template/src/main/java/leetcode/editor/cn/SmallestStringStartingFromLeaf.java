/*
 * @lc app=leetcode.cn id=988 lang=java
 * @lcpr version=30403
 *
 * [988] 从叶结点开始的最小字符串
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SmallestStringStartingFromLeaf {

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
        public String smallestFromLeaf(TreeNode root) {

            tranverse(root);
            return res;
            
        }
        StringBuilder path = new StringBuilder();
        String res = null;
        void tranverse(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                // 到达叶子节点，更新答案
                path.append((char)(root.val + 'a'));

                // 翻转一下
                path.reverse();

                String tmp = path.toString();
                // 找到更新的更新答案
                if (res == null || res.compareTo(tmp) > 0) {
                    res = tmp;
                }
                // 恢复
                path.reverse();

                path.deleteCharAt(path.length() - 1);
                
                //已经是叶子节点，提前结束
                return;
            }
            path.append((char)(root.val + 'a'));

            tranverse(root.left);
            tranverse(root.right);

            path.deleteCharAt(path.length() - 1);
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new SmallestStringStartingFromLeaf().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [0,1,2,3,4,3,4]\n
// @lcpr case=end

// @lcpr case=start
// [25,1,3,1,3,0,2]\n
// @lcpr case=end

// @lcpr case=start
// [2,2,1,null,1,0,null,0]\n
// @lcpr case=end

 */

