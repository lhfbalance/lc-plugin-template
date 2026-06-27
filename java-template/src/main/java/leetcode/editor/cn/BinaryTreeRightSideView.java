/*
 * @lc app=leetcode.cn id=199 lang=java
 * @lcpr version=30403
 *
 * [199] 二叉树的右视图
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class BinaryTreeRightSideView {

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
        public List<Integer> rightSideView(TreeNode root) {
            
            levelTranverse(root);
            return res;
        }
        List<Integer> res = new LinkedList<>();
        void levelTranverse(TreeNode root) {
            if (root == null) {
                return;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                // 取这一层的第一个
                TreeNode first = queue.peek();
                res.add(first.val);
                for(int i = 0; i < size ; i++) {
                    TreeNode node = queue.poll();
                    // 先放右节点，保证每一层是从右往左放的
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                }
            }
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,2,3,null,5,null,4]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,null,null,null,5]\n
// @lcpr case=end

// @lcpr case=start
// [1,null,3]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */

