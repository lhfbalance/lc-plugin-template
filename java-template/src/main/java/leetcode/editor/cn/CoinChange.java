/*
 * @lc app=leetcode.cn id=322 lang=java
 * @lcpr version=30403
 *
 * [322] 零钱兑换
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class CoinChange {

    // @lc code=start
    class Solution {

         public int coinChange(int[] coins, int amount) {
            int dp[] = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for(int i = 1; i < dp.length; i++) {
                
                for(int coin : coins) {
                    if (i - coin < 0) {
                        continue;
                    }
                    // 如果所有的子问题 dp[i-coin]无解，则 当前问题也无解，
                    // 因为 dp[i]的初始化值为 amount+1,所以当子问题无解时，dp[i]值不变
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
            return dp[amount] == amount + 1 ? -1 : dp[amount];
            
         }

        public int coinChange1(int[] coins, int amount) {
            memo = new int[amount + 1];
            Arrays.fill(memo, -1000);
            return dp(coins, amount);
        }

        int[] memo;
        int dp(int[] coins, int amount) {
            if (amount < 0) {
                return -1;
            }
            if (amount == 0) {
                return 0;
            }
            if (memo[amount] != -1000) {
                return memo[amount];
            }
            int tempRes = Integer.MAX_VALUE;
            for(int coin : coins) {
                int subRes = dp(coins, amount - coin);
                if (subRes == -1) {
                    // 子问题无解，跳过
                    continue;
                }
                tempRes = Math.min(tempRes, subRes + 1);
            }
            // 如果所有子问题均无解，这 tempRes 值不变，也应该返回-1
            memo[amount] = (tempRes == Integer.MAX_VALUE ? -1 : tempRes);
            return memo[amount];
        }

    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        int[] coins = {2};
        solution.coinChange(coins, 3);
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,2,5]\n11\n
// @lcpr case=end

// @lcpr case=start
// [2]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1]\n0\n
// @lcpr case=end

 */

