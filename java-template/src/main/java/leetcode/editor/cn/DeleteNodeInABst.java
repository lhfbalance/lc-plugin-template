/*
 * @lc app=leetcode.cn id=450 lang=java
 * @lcpr version=30403
 *
 * [450] 删除二叉搜索树中的节点
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class DeleteNodeInABst {

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
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (root.val == key) {
                // 找到了，删除它
                if (root.left == null) {
                    // 让右子节点接替
                    return root.right;
                } else if (root.right == null) {
                    // 让左子节点接替
                    return root.left;
                } else {
                    // 让左子节点的最大值或着让右子节点的最小值接替
                    // 选择右子节点最小值接替试试
                    TreeNode minNode = getMinNode(root.right);
                    // 有操作的情况下就一定要接收
                    root.right = deleteNode(root.right, minNode.val);
                    // 用 minNode 替换 root
                    minNode.left = root.left;
                    minNode.right = root.right;
                    // 把 minNode 返回回去让上层接收
                    return minNode;
                }
            } else if (root.val > key) {
                // 到左子树去寻找并删除
                root.left = deleteNode(root.left, key);
                return root;
            } else {
                // 到右子树寻找并删除
                root.right = deleteNode(root.right, key);
                return root;
            }
        }

        private TreeNode getMinNode(TreeNode root) {
            
            TreeNode p = root;
            if (p == null) {
                return null;
            }
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }

    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new DeleteNodeInABst().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [5,3,6,2,4,null,7]\n3\n
// @lcpr case=end

// @lcpr case=start
// [5,3,6,2,4,null,7]\n0\n
// @lcpr case=end

// @lcpr case=start
// []\n0\n
// @lcpr case=end

 */

