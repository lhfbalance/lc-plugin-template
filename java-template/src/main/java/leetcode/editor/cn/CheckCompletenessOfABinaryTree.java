/*
 * @lc app=leetcode.cn id=958 lang=java
 * @lcpr version=30403
 *
 * [958] 二叉树的完全性检验
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class CheckCompletenessOfABinaryTree {

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
    class State {
        TreeNode node;
        int seq;
        State(TreeNode node, int seq) {
            this.node = node;
            this.seq = seq;
        }

    }
    
    class Solution {
        public boolean isCompleteTree(TreeNode root) {
            levelTranverse(root);
            return res;
        }
        boolean res = true;
        void levelTranverse(TreeNode root) {
            if (root == null) {
                return;
            }
            Queue<State> queue = new LinkedList<>();
            queue.offer(new State(root, 1));
            int pre = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                
                for(int i = 0; i < size ; i++) {
                    State cur = queue.poll();
                    if (cur.seq != pre + 1) {
                        res = false;
                        return;
                    }
                    pre = cur.seq;
                    if (cur.node.left != null) {
                        queue.offer(new State(cur.node.left, 2 * cur.seq));
                    }
                    if (cur.node.right != null) {
                        queue.offer(new State(cur.node.right, 2 * cur.seq + 1));
                    }
                }

            }
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new CheckCompletenessOfABinaryTree().new Solution();
        Integer[] arr = {1,2,3,4,5,6};
        solution.isCompleteTree(TreeNode.createRoot(arr));
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,2,3,4,5,6]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5,null,7]\n
// @lcpr case=end

 */

