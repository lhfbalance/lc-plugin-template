/*
 * @lc app=leetcode.cn id=124 lang=java
 * @lcpr version=30403
 *
 * [124] 二叉树中的最大路径和
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class BinaryTreeMaximumPathSum {

    // @lc code=start
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        int res = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 计算单边路径和时顺便计算最大路径和
            oneSideMax(root);
            return res;
        }

        // 定义：计算从根节点 root 为起点的最大单边路径和
        int oneSideMax(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 这里为什么要和 0 取最大，因为如果子树和是负数，那带上子树的和还不如不带，
            // 写全一点。其实是取这三个值的最大值
            // 1.oneSideMax(root.left) + root.val; 
            // 2.root.val, 
            // 3.oneSideMax(root.right) + root.val
            int leftMaxSum = Math.max(0, oneSideMax(root.left));
            int rightMaxSum = Math.max(0, oneSideMax(root.right));
            // 后序遍历位置，顺便更新最大路径和，这里的语义是以当前节点作为拐点的路径和
            // 也正因为这个语义，所以递归函数的定义是以根节点为起点的最大单边路径和，和以当前节点作为拐点的路径和正好契合
            int pathMaxSum = root.val + leftMaxSum + rightMaxSum;
            // 遍历了所有节点，且取其中最大值
            res = Math.max(res, pathMaxSum);
            // 实现函数定义，左右子树的最大单边路径和加上根节点的值
            // 就是从根节点 root 为起点的最大单边路径和
            return Math.max(leftMaxSum, rightMaxSum) + root.val;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
        Integer[] arr = {-11,9,20,null,null,15,7};
        System.out.println(solution.oneSideMax(TreeNode.createRoot(arr)));
        // System.out.println(solution.maxPathSum(TreeNode.createRoot(arr)));

        // put your test code here

    }
}

/*
 * // @lcpr case=start
 * // [1,2,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [-10,9,20,null,null,15,7]\n
 * // @lcpr case=end
 * 
 */
