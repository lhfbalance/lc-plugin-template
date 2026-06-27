/*
 * @lc app=leetcode.cn id=279 lang=java
 * @lcpr version=30403
 *
 * [279] 完全平方数
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class PerfectSquares {

    // @lc code=start
    class Solution {
        int[] memo;
        public int numSquares(int n) {
            memo = new int[n + 1];
            Arrays.fill(memo, Integer.MAX_VALUE);
            return dp(n);
        }

        int dp(int n) {
            if (n == 0) {
                return 0;
            }

            if (memo[n] != Integer.MAX_VALUE) {
                return memo[n];
            }
            // 状态
            int temp = Integer.MAX_VALUE;
            for(int i = 1; i * i <= n; i++) {
                temp = Math.min(temp, dp(n - i*i) + 1);
            }
            memo[n] = temp;
            return memo[n];
        }

        public int numSquares1(int n) {
            int[] minCnt = new int[n + 1];
            Arrays.fill(minCnt, Integer.MAX_VALUE);
            minCnt[0] = 0;
            minCnt[1] = 1;
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j*j <= i ; j++) {
                    minCnt[i] = Math.min(minCnt[i], minCnt[i - j * j] + 1);
                }
            }
            return minCnt[n];
            
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new PerfectSquares().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// 12\n
// @lcpr case=end

// @lcpr case=start
// 13\n
// @lcpr case=end

 */

