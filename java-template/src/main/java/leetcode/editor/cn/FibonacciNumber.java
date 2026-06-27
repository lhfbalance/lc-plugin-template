/*
 * @lc app=leetcode.cn id=509 lang=java
 * @lcpr version=30403
 *
 * [509] 斐波那契数
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class FibonacciNumber {

    // @lc code=start
    class Solution {

        public int fib(int n) {
            if (n == 0 || n == 1) {
                return n;
            }
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for(int i = 2; i < n + 1; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
            return dp[n];
        }
        
        public int fib1(int n) {
            memo = new int[n + 1];
            Arrays.fill(memo, -666);
            return dp(n);
        }
        int[] memo;

        public int dp(int n) {
            if (memo[n] != -666) {
                return memo[n];
            }
            if (n == 0) {
                memo[0] = 0;
                return 0;
            }
            if (n == 1) {
                memo[1] = 1;
                return 1;
            }

            int res =  dp(n - 1) + dp(n - 2);
            memo[n] = res;
            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new FibonacciNumber().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// 2\n
// @lcpr case=end

// @lcpr case=start
// 3\n
// @lcpr case=end

// @lcpr case=start
// 4\n
// @lcpr case=end

 */

