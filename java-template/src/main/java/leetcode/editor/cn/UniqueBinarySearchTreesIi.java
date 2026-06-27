/*
 * @lc app=leetcode.cn id=95 lang=java
 * @lcpr version=30403
 *
 * [95] 不同的二叉搜索树 II
 */

package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class UniqueBinarySearchTreesIi {

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
        public List<TreeNode> generateTrees(int n) {
           List<TreeNode> res = build(1, n);
           return res;
            
        }

        List<TreeNode> build(int lo, int hi) {
            List<TreeNode> res = new LinkedList<>();
            if (lo > hi) {
                // 这个 base case 非常关键，null 节点一定要构建出来，才能穷举正确，因为 null 的位置不同，树也不一样
                res.add(null);
                return res;
            }
            if (lo == hi) {
                // 这个 base case 可以没有，下面的逻辑会覆盖这个 case
                res.add(new TreeNode(lo));
                return res;
            }
            
            for(int i = lo; i<= hi; i++) {
                List<TreeNode> leftTotal = build(lo, i-1);
                List<TreeNode> rightTotal = build(i+1, hi);

                // 选择根节点，二叉搜索树的种类应该是左子树种类*右子树种类，所以是两个 for 循环
                for(TreeNode leftnode: leftTotal) {
                    for(TreeNode rightNode : rightTotal) {
                        // 在两个 for 循环里构建树，穷举左右子树的组合
                        TreeNode root = new TreeNode(i);
                        root.left = leftnode;
                        root.right = rightNode;
                        res.add(root);
                    }
                }
            }
            return res;

        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTreesIi().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// 3\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

