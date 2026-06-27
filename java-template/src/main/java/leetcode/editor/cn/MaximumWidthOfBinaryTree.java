/*
 * @lc app=leetcode.cn id=662 lang=java
 * @lcpr version=30403
 *
 * [662] 二叉树最大宽度
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MaximumWidthOfBinaryTree {

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
    public class State {
        TreeNode node;
        int seq;
        State(TreeNode node, int seq) {
            this.node = node;
            this.seq = seq;
        }

    }
    class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            levelTranverse(root);
            return res;
        }

        int res = 0;
        void levelTranverse(TreeNode root) {
            if (root == null) {
                return;
            }
            Queue<State> queue = new LinkedList<>();
            // 编号应该从 1 起，不能从 0 起，从 0 起会导致左子树也是 0
            queue.offer(new State(root, 1));
            while (!queue.isEmpty()) {
                int size = queue.size();
                // 每层的第一个元素
                State first = queue.peek();
                // 每层的最后一个元素
                State last = null;
                for(int i = 0; i < size ; i++) {
                    last = queue.poll();
                    if (last.node.left != null) {
                        queue.offer(new State(last.node.left, 2 * last.seq));
                    }
                    if (last.node.right != null) {
                        queue.offer(new State(last.node.right, 2 * last.seq + 1));
                    }
                }
                // 宽度是每层的最后一个元素序列号 - 第一个元素序列号 + 1
                // 更新结果
                res = Math.max(last.seq - first.seq + 1, res);

            }
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new MaximumWidthOfBinaryTree().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,3,2,5,3,null,9]\n
// @lcpr case=end

// @lcpr case=start
// [1,3,2,5,null,null,9,6,null,7]\n
// @lcpr case=end

// @lcpr case=start
// [1,3,2,5]\n
// @lcpr case=end

 */

