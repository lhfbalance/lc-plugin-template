/*
 * @lc app=leetcode.cn id=198 lang=java
 * @lcpr version=30403
 *
 * [198] 打家劫舍
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class HouseRobber {

    // @lc code=start
    class Solution {

        // 压缩空间
        public int rob(int[] nums) {
            // 状态从第 i 个房屋开始偷，选择，偷或不偷
            // dp数组值为最大金额
            int n = nums.length;
            int dpi2 = 0;
            int dpi1 = 0;
            int dpi = 0;
            for(int i = n - 1; i >= 0; i--) {
                dpi = Math.max(dpi1, nums[i] + dpi2);
                dpi2 = dpi1;
                dpi1 = dpi;
            }
            return dpi;
            
        }
        public int rob2(int[] nums) {
            // 状态从第 i 个房屋开始偷，选择，偷或不偷
            // dp数组值为最大金额
            int n = nums.length;
            int[] dp = new int[n + 2];
            Arrays.fill(dp, -1);
            dp[n] = 0;
            dp[n+1] = 0;
            for(int i = n - 1; i >= 0; i--) {
                dp[i] = Math.max(dp[i + 1], nums[i] + dp[i+2]);
            }
            return dp[0];
            
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,2,3,1]\n
// @lcpr case=end

// @lcpr case=start
// [2,7,9,3,1]\n
// @lcpr case=end

 */

