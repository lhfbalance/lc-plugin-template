/*
 * @lc app=leetcode.cn id=70 lang=java
 * @lcpr version=30403
 *
 * [70] 爬楼梯
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ClimbingStairs {

    // @lc code=start
    class Solution {

        public int climbStairs(int n) {
            memo = new int[n + 1];
            Arrays.fill(memo, -666);
            return dp(n);
            
        }
        int[] choices = {1, 2};
        int[] memo;

        //返回值是爬 n 阶的方式
        private int dp(int n) {
            if (memo[n] != -666) {
                return memo[n];
            }
            if (n == 2) {
                return 2;
            }
            if (n == 1) {
                return 1;
            }
            int res = 0;
            // 爬到 n 阶两种方式
            // 从 n-1阶爬 1 次
            // 从 n-2阶爬 1 次
            // 所一次爬到 n 阶的方式等于爬到 n-1 的方式加上爬到 n-2的方式
            for(int choice : choices) {
                res += dp(n - choice);
            }
            memo[n] = res;
            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
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

 */

