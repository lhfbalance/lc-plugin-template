/*
 * @lc app=leetcode.cn id=121 lang=java
 * @lcpr version=30403
 *
 * [121] 买卖股票的最佳时机
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class BestTimeToBuyAndSellStock {

    // @lc code=start
    class Solution {
        public int maxProfit(int[] prices) {
            // 三个状态，时间，最大交易此时，是否持有股票
            int[][] dp = new int[prices.length + 1][2];
            // dp[0][0][0] = 0;
            // dp[0][1][1] = Integer.MIN_VALUE;
            // for(int i = 1; i <= prices.length; i++) {
            //     dp[i][0][0] = 0;
            //     dp[i][0][1] = Integer.MIN_VALUE;
            // }
            dp[0][0] = 0;
            dp[0][1] = Integer.MIN_VALUE;

            for(int i = 1; i < prices.length + 1; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i-1][1] + prices[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i - 1]);
            }
            return dp[prices.length][0];
            
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [7,1,5,3,6,4]\n
// @lcpr case=end

// @lcpr case=start
// [7,6,4,3,1]\n
// @lcpr case=end

 */

