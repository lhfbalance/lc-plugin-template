/*
 * @lc app=leetcode.cn id=53 lang=java
 * @lcpr version=30403
 *
 * [53] 最大子数组和
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MaximumSubarray {

    // @lc code=start
    class Solution {

        /**
         * 
         * 三种思路，
         * 滑动窗口，动态规划，前缀和
         */

        public int maxSubArray(int[] nums) {

            int window = 0;
            int res = Integer.MIN_VALUE;
            int left = 0;
            // 左闭右开
            int right = 0;
            while (right < nums.length) {
                // 扩大窗口
                window = window + nums[right];
                right++;
                // 更新答案
                res = Math.max(res, window);

                // 缩小窗口
                while (window < 0) {
                    window = window - nums[left];
                    left++;
                }
            }
            return res;

        }

        /**
         * 
         * 前缀和
         */
        public int maxSubArray3(int[] nums) {
            int[] preSum = new int[nums.length + 1];
            preSum[0] = 0;
            for(int i = 1 ; i < nums.length + 1; i++) {
                preSum[i] = preSum[i-1] + nums[i-1];
            }

            int minPre = 0;
            int res = Integer.MIN_VALUE;
            for(int i = 1; i < nums.length + 1; i++) {
                res = Math.max(preSum[i] - minPre, res);
                minPre = Math.min(minPre, preSum[i]);
            }
            return res;
        }

        /**
         * 压缩空间技巧
         */
        public int maxSubArray2(int[] nums) {
            int n = nums.length;
            
            int pre = nums[0];
            //[0, i]; 以 i 结尾的子数组的最大和,dp[0] 
            int res = pre;
            for(int i = 1; i < n; i++) {
                pre = Math.max(pre + nums[i], nums[i]);
                res = Math.max(res, pre);
            }
            return res;
        }

        public int maxSubArray1(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];
            //[0, i]; 以 i 结尾的子数组的最大和,dp[0] 
            int res = dp[0];
            for(int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        solution.maxSubArray(arr);
        // put your test code here

    }
}



/*
// @lcpr case=start
// [-2,1,-3,4,-1,2,1,-5,4]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

// @lcpr case=start
// [5,4,-1,7,8]\n
// @lcpr case=end

 */

