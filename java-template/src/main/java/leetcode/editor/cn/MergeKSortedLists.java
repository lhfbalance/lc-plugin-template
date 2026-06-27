/*
 * @lc app=leetcode.cn id=23 lang=java
 * @lcpr version=30403
 *
 * [23] 合并 K 个升序链表
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MergeKSortedLists {

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
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }

            return mergeKLists(lists, 0, lists.length - 1);

        }

        // 分解问题
        ListNode mergeKLists(ListNode[] lists, int start, int end) {
            if (start == end) {
                // base case
                return lists[start];
            }
            int mid = (start + end)/2;
            ListNode l1 = mergeKLists(lists, start, mid);
            ListNode l2 = mergeKLists(lists, mid + 1, end);

            return mergeTwoLists(l1, l2);
        }

        // 合并子问题
        ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(-100000);
            ListNode p = dummy;
            ListNode head1 = list1;
            ListNode head2 = list2;
            while (head1 != null && head2 != null) {
                if (head1.val < head2.val) {
                    p.next = head1;
                    head1 = head1.next;
                } else {
                    p.next = head2;
                    head2 = head2.next;
                }
                p = p.next;
            }
            if (head1 != null) {
                p.next = head1;
            } 
            if (head2 != null) {
                p.next = head2;
            }
            return dummy.next;

        }

        public ListNode mergeKLists1(ListNode[] lists) {
            ListNode dummy = new ListNode(0);
            ListNode p = dummy;
            PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {

                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
                
            });
            for(ListNode head : lists) {
                if (head != null) {
                    queue.offer(head);
                }
            }

            while (!queue.isEmpty()) {
                ListNode node = queue.poll();
                if (node.next != null) {
                    queue.add(node.next);
                }
                p.next = node;
                p = p.next;
            }
            return dummy.next;
            
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [[1,4,5],[1,3,4],[2,6]]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [[]]\n
// @lcpr case=end

 */

