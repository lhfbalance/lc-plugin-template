/*
 * @lc app=leetcode.cn id=148 lang=java
 * @lcpr version=30403
 *
 * [148] 排序链表
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SortList {

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
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                //直接返回
                return head;
            }
            // 使用合并排序
            // 使用快慢指针将链表分成两段
            ListNode slow = head;
            // 为什么 fast 要
            // ListNode fast = head.next;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode mid = slow;
            ListNode next = mid.next;
            mid.next = null;
            ListNode l1 = sortList(head);
            ListNode l2 = sortList(next);
            return merge(l1, l2);
        }

        // 合并两个有序链表
        ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode p = dummy;
            ListNode p1 = l1;
            ListNode p2 = l2;
            while (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    p.next = p1;
                    
                    p1 = p1.next;
                } else {
                    p.next = p2;
                    p2 = p2.next;
                }
                p = p.next;
            }
            
            p.next = (p1 !=null ? p1 : p2);
            return dummy.next;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [4,2,1,3]\n
// @lcpr case=end

// @lcpr case=start
// [-1,5,3,4,0]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */

