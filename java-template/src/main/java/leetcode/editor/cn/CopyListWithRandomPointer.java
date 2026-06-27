/*
 * @lc app=leetcode.cn id=138 lang=java
 * @lcpr version=30403
 *
 * [138] 随机链表的复制
 */

package leetcode.editor.cn;

import java.util.*;

import org.w3c.dom.Node;

import leetcode.editor.common.*;

public class CopyListWithRandomPointer {

    // @lc code=start
    
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    
    
    class Solution {
        public Node copyRandomList(Node head) {
            // 一个 hash 表，两次遍历
            Map<Node, Node> map = new HashMap<>();
            Node p = head;
            while (p != null) {
                Node node = new Node(p.val);
                map.put(p, node);
                p = p.next;
                
            }
            p = head;
            while (p != null) {
                if (p.next != null) {
                    map.get(p).next = map.get(p.next);
                }
                if (p.random != null) {
                    map.get(p).random = map.get(p.random);
                }
                p = p.next;
            }

            return map.get(head);
            
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new CopyListWithRandomPointer().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [[7,null],[13,0],[11,4],[10,2],[1,0]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,1],[2,1]]\n
// @lcpr case=end

// @lcpr case=start
// [[3,null],[3,0],[3,null]]\n
// @lcpr case=end

 */

