/*
 * @lc app=leetcode.cn id=117 lang=java
 * @lcpr version=30403
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

package leetcode.editor.cn;

import java.util.*;

import org.w3c.dom.Node;

import leetcode.editor.common.*;

public class PopulatingNextRightPointersInEachNodeIi {

    // @lc code=start
    /*
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    */
    
    class Solution {
        // public Node connect(Node root) {
        //     // levelTranverse(root);
        //     // return root;
        // }

        void levelTranverse(Node root) {
            // if (root == null) {
            //     return;
            // }
            // Queue<Node> queue = new LinkedList<>();
            // queue.offer(root);

            // while (!queue.isEmpty()) {
            //     int size = queue.size();
            //     Node pre = null;
            //     for(int i = 0 ; i< size ; i++ ) {
            //         Node cur = queue.poll();
            //         if (pre != null) {
            //             pre.next = cur;
            //         }
            //         pre = cur;
            //         if (cur.left != null) {
            //             queue.offer(cur.left);
                        
            //         }
            //         if (cur.right != null) {
            //             queue.offer(cur.right);
                        
            //         }
            //     }
            // }
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        // Solution solution = new PopulatingNextRightPointersInEachNodeIi().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,2,3,4,5,null,7]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */

