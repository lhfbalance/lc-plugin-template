/*
 * @lc app=leetcode.cn id=863 lang=java
 * @lcpr version=30403
 *
 * [863] 二叉树中所有距离为 K 的结点
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class AllNodesDistanceKInBinaryTree {

    // @lc code=start
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        HashMap<Integer, TreeNode> parents = new HashMap<>();
        // HashMap<Integer, TreeNode> all = new HashMap<>();

        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

            List<Integer> res = new LinkedList<>();
            List<Integer> visited = new LinkedList<>();
            traverse(root);

            Queue<TreeNode> queue = new LinkedList<>();
            visited.add(target.val);
            queue.offer(target);
            int step = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for(int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    if (step == k) {
                        res.add(cur.val);
                    }
                    // 三叉树
                    if (parents.get(cur.val) != null && !visited.contains(parents.get(cur.val).val)) {
                        visited.add(parents.get(cur.val).val);
                        queue.offer(parents.get(cur.val));    
                    }
                    if (cur.left != null && !visited.contains(cur.left.val)) {
                        visited.add(cur.left.val);
                        queue.offer(cur.left);    
                    }
                    if (cur.right != null && !visited.contains(cur.right.val)) {
                        visited.add(cur.right.val);
                        queue.offer(cur.right);    
                    }
                }
                step++;
            }
            return res;
            
        }

        void traverse(TreeNode root) {
            if (root == null) {
                return;
            }

            traverse(root.left);
            traverse(root.right);

            // all.put(root.val, root);

            if (root.left != null) {
                parents.put(root.left.val, root);
            }
            if (root.right != null) {
                parents.put(root.right.val, root);
            }
        }


    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new AllNodesDistanceKInBinaryTree().new Solution();

        Integer[] arr = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(2);
        solution.distanceK(TreeNode.createRoot(arr), treeNode, 2);

        // put your test code here

    }
}



/*
// @lcpr case=start
// [3,5,1,6,2,0,8,null,null,7,4]\n5\n2\n
// @lcpr case=end

// @lcpr case=start
// [1]\n1\n3\n
// @lcpr case=end

 */

