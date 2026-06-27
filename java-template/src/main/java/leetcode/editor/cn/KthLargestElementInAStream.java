/*
 * @lc app=leetcode.cn id=703 lang=java
 * @lcpr version=30403
 *
 * [703] 数据流中的第 K 大元素
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class KthLargestElementInAStream {

    // @lc code=start
    class KthLargest {

        private PriorityQueue<Integer> queue = new PriorityQueue<>();
        int capacity;
    
        public KthLargest(int k, int[] nums) {
            this.capacity = k;
            for(int i = 0; i< nums.length;i++) {
                add(nums[i]);
            }
        }
        
        public int add(int val) {
            queue.add(val);
            if (queue.size() > capacity) {
                queue.poll();
            }
            return queue.peek();
        }
    }
    
    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     */
    // @lc code=end

    public static void main(String[] args) {
        // KthLargestElementInAStream solution = new KthLargestElementInAStream().new KthLargest();
        // put your test code here

    }
}



/*
// @lcpr case=start
// ["KthLargest","add","add","add","add","add"]\n[[3,[4,5,8,2]],[3],[5],[10],[9],[4]]\n["KthLargest","add","add","add","add"]\n[[4,[7,7,7,7,8,3]],[2],[10],[9],[9]]\n
// @lcpr case=end

 */

