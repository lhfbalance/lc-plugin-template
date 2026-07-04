/*
 * @lc app=leetcode.cn id=114 lang=java
 * @lcpr version=30403
 *
 * [114] 二叉树展开为链表
 */

package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class FlattenBinaryTreeToLinkedList {

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
        public void flatten(TreeNode root) {
            // 返回值是 void，必须在原树上做改动
            // 遍历的方式需要借助外部变量，不适合
            // 分解问题的方式要定义要给合适的递归函数，并且一般有返回值，但是这道题比较特殊
            // 因为他就是要对这棵树做操作
            if (root == null) {
                // base case 什么都不做
                return;
            }

            // 拉平左子树
            flatten(root.left);
            // 拉平右子树
            flatten(root.right);
            // 将左子树挂载根节点的右子树上，
            TreeNode temp = root.right;
            root.right = root.left;
            // 左子树置空
            root.left = null;
            // 走到新的右子树底部
            TreeNode p = root;
            while (p.right != null) {
                p = p.right;
            }
            // 把原来的右子树挂在拉平后的左子树末尾
            p.right = temp;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,2,5,3,4,null,6]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

 */

