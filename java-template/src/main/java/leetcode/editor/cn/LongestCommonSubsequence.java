/*
 * @lc app=leetcode.cn id=1143 lang=java
 * @lcpr version=30403
 *
 * [1143] 最长公共子序列
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class LongestCommonSubsequence {

    // @lc code=start
    class Solution {

        public int longestCommonSubsequence(String text1, String text2) {
            int[][] dp = new int[text1.length() + 1][text2.length() + 1];
          
            for(int i = 1; i <=text1.length(); i++) {

                for(int j = 1; j<=text2.length();j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }

            }
            return dp[text1.length()][text2.length()];
        }

        // 错误答案
        /*
        public int longestCommonSubsequence(String text1, String text2) {
            int[][] dp = new int[text1.length() + 1][text2.length() + 1];
            int i = 1,j = 1;
            while (i < text1.length() + 1 && j < text2.length() + 1) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    i++;
                    j++;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + 1;
                    if (dp[i - 1][j] > dp[i][j-1]) {
                        j ++;
                    } else {
                        i ++;
                    }
                }
            }
            return dp[i-1][j-1];
        } */

        public int longestCommonSubsequence1(String text1, String text2) {
            memo = new int[text1.length() + 1][text2.length() + 1];
            for(int i = 0; i < memo.length; i ++) {
                Arrays.fill(memo[i], -1);
            }
            
            return dp(text1, 0, text2, 0);
        }

        int[][] memo;
        int dp(String text1, int i, String text2, int j) {
            if (i == text1.length() || j == text2.length()) {
                return 0;
            }
            if (memo[i][j] != -1) {
                return memo[i][j];
            }

            int res;
            if (text1.charAt(i) == text2.charAt(j)) {
                res = dp(text1, i + 1, text2, j + 1) + 1;
            } else {
                res = Math.max(dp(text1, i, text2, j + 1), dp(text1, i + 1, text2, j));
            }
            memo[i][j] = res;
            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new LongestCommonSubsequence().new Solution();
        String s1 = "abcde";
        String s2 = "ace";
        solution.longestCommonSubsequence(s1, s2);
        // put your test code here

    }
}



/*
// @lcpr case=start
// "abcde"\n"ace"\n
// @lcpr case=end

// @lcpr case=start
// "abc"\n"abc"\n
// @lcpr case=end

// @lcpr case=start
// "abc"\n"def"\n
// @lcpr case=end

 */

