/*
 * @lc app=leetcode.cn id=382 lang=java
 * @lcpr version=30403
 *
 * [382] 链表随机节点
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class LinkedListRandomNode {

    // @lc code=start
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {

        ListNode head;
        Random random = new Random();

        public Solution(){}
    
        public Solution(ListNode head) {
            this.head = head;
        }
        
        public int getRandom() {
            int i = 0;
            int res = -1;
            ListNode p = head;
            while (p != null) {
                i++;
                // 产生[0,i) 之间的随机数，是 0 的概率是 1/i;
                int r = random.nextInt(i);
                if (r == 0) {
                    // 如果等于零则用当前节点替换，不等于零则保持之前的选择
                    res = p.val;
                }
                p = p.next;
            }
            return res;
        }
    }
    
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(head);
     * int param_1 = obj.getRandom();
     */
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new LinkedListRandomNode().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// ["Solution","getRandom","getRandom","getRandom","getRandom","getRandom"]\n[[[1,2,3]],[],[],[],[],[]]\n
// @lcpr case=end

 */

