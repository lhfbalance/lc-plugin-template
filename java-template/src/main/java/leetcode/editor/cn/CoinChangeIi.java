/*
 * @lc app=leetcode.cn id=518 lang=java
 * @lcpr version=30403
 *
 * [518] 零钱兑换 II
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class CoinChangeIi {

    // @lc code=start
    class Solution {

        /**
         * 空间压缩，压缩后代码其实难读了很多
         */
        public int change3(int amount, int[] coins) {
            int n = coins.length;
            int[] dp = new int[amount+1];
            
            dp[0] = 1;
            
            for(int i = 1; i < n+1; i++) {
                
                for(int j = 1; j < amount + 1; j++) {
                    
                    if(j - coins[i - 1] < 0) {
                        dp[j] = dp[j];
                    } else {
                        dp[j] = dp[j] + dp[j - coins[i - 1]];
                    }
                    
                }
            }
            return dp[amount];
        }

        /**
         * 空间压缩
         */
        public int change2(int amount, int[] coins) {
            int n = coins.length;
            int[][] dp = new int[n+1][amount+1];
            for(int i = 1; i< n+1; i++) {
                dp[i][0] = 1;
            }
            for(int i = 1; i < n+1; i++) {
                for(int j = 1; j < amount + 1; j++) {
                    if(j - coins[i - 1] < 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                    }
                }
            }
            return dp[n][amount];
        }

        public int change1(int amount, int[] coins) {
            // 状态就是总金额，和可选择的硬币，选择就是要选
            // dp 函数
            // 状态转移逻辑
            memo = new int[coins.length + 1][amount + 1];
            for(int i = 0; i < memo.length; i++) {
                Arrays.fill(memo[i], -1);
            }
            
            
            return dp(coins, coins.length, amount);
        }
        
        int[][] memo;
        int dp(int[] coins, int index, int amount) {

            // base case
            if (amount == 0) {
                return 1;
            }
            
            if (index <= 0) {
                return 0;
            }

            if (memo[index][amount] != -1) {
                return memo[index][amount];
            }

            
            if (coins[index - 1] > amount) {
                // 当前硬币的面值大于总金额了，就不选了
                memo[index][amount] = dp(coins, index - 1, amount);
            } else {
                // 选或不选当前硬币
                memo[index][amount] = dp(coins, index - 1, amount) + dp(coins, index, amount - coins[index - 1]);
            }
            return memo[index][amount];
        }

        public int change(int amount, int[] coins) {
            cantFound = new boolean[coins.length][amount + 1];
            backtrack(amount, coins, 0);
            return result;
        }

        // 回溯，会超时的解法
        List<Integer> path = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        int sum = 0;
        boolean exceed = false;
        int result;
        
        boolean[][] cantFound;
        void backtrack(int amout, int[] coins, int start) {

            if (sum > amout) {
                // 超过直接返回
                exceed = true;
                return;
            }
            if (sum == amout) {
                // 找到答案
                res.add(new LinkedList<>(path));
                result++;
                return;
            }
            if (cantFound[start][sum]) {
                // 新增剪枝
                result++;
                return;
            }

            for(int i = start; i < coins.length; i++) {
                path.addLast(coins[i]);
                sum += coins[i];

                backtrack(amout, coins, i);

                sum -= coins[i];
                path.removeLast();
            }

            if (exceed) {
                cantFound[start][sum] = true;
            }

        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new CoinChangeIi().new Solution();
        int[] coins = {1,2,5};
        System.out.println("begin");
        System.out.println("result=" + solution.change(5, coins));
        System.out.println("end");
        // put your test code here

    }
}



/*
// @lcpr case=start
// 5\n[1,2,5]\n
// @lcpr case=end

// @lcpr case=start
// 3\n[2]\n
// @lcpr case=end

// @lcpr case=start
// 10\n[10]\n
// @lcpr case=end

 */

