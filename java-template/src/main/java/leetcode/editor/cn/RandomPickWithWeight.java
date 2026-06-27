/*
 * @lc app=leetcode.cn id=528 lang=java
 * @lcpr version=30403
 *
 * [528] 按权重随机选择
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RandomPickWithWeight {

    // @lc code=start
    class Solution {

        int[] preSum;
        Random random = new Random();
    public Solution() {}
        public Solution(int[] w) {
            preSum = new int[w.length + 1];
            preSum[0] = 0;
            for(int i= 1; i<preSum.length; i++) {
                preSum[i] = preSum[i-1] + w[i-1];
            }
        }
        
        public int pickIndex() {
            // 要在 1 - preSum[preSum.length -1] 中间随机一个数
            // nextInt是在[0,bound)之间随机一个数，+1后正好满足诉求
            int target = random.nextInt(preSum[preSum.length -1]) + 1;

            return findLeftBound(preSum, 1, preSum.length - 1, target) - 1;
            
        }

        int findLeftBound(int[] nums, int start, int end, int target) {
            // 因为 target 不会等于 0,所以其实有没有 start 都可以
            int left = start;
            int right = end;
            while (left <= right) {
                int mid = left + (right - left)/2;
                if (nums[mid] == target) {
                    right = mid - 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
    
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(w);
     * int param_1 = obj.pickIndex();
     */
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new RandomPickWithWeight().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// ["Solution","pickIndex"]\n[[[1]],[]]\n["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]\n[[[1,3]],[],[],[],[],[]]\n
// @lcpr case=end

 */

