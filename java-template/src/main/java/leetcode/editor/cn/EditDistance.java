/*
 * @lc app=leetcode.cn id=72 lang=java
 * @lcpr version=30403
 *
 * [72] 编辑距离
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class EditDistance {

    // @lc code=start
    class Solution {
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            // for(int i = 0; i < word1.length() + 1; i++) {
            //     for(int j = 0; j < word2.length() + 1; j ++) {
            //         if (i == 0) {
            //             dp[i][j] = j;
            //         }
            //         if (j == 0) {
            //             dp[i][j] = i;
            //         }
            //     }
            // } 
            for(int i = 1; i <= word1.length(); i++) {
                dp[i][0] = i;
            }
            for(int j = 1; j <= word2.length(); j++) {
                dp[0][j] = j;
            }

            for(int i = 1; i < word1.length() + 1; i++) {
                for(int j = 1; j < word2.length() + 1; j ++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        // 插入，删除，替换
                        dp[i][j] = min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1;
                    }
                }
            }
            return dp[word1.length()][word2.length()];
        }

        public int minDistance1(String word1, String word2) {
            // 状态和选择，两个指针，插入，删除，替换，什么也不做
            // dp函数的定义，word1 前 i 个字符变成 word2 前 j 个字符，需要的操作数，注意i和 j 都是从 0 起
            // 状态转移的逻辑
            memo = new int[word1.length() + 1][word2.length() + 1];
            return dp(word1, word1.length() - 1, word2,  word2.length() - 1);
            
        }

        int[][] memo;
        //都说递归代码的可解释性很好
        int dp(String word1, int i, String word2, int j) {
            // base case
            if (i == -1) {
                return j + 1;
            }
            if (j == -1) {
                 return i + 1;
            }
            if (memo[i][j] != 0) {
                return memo[i][j];
            }
            
            if (word1.charAt(i) == word2.charAt(j)) {
                memo[i][j] = dp(word1, i - 1, word2, j - 1);
            } else {
                memo[i][j] = min(
                    dp(word1, i, word2, j - 1), // 在i 后面插入
                    dp(word1, i - 1, word2, j), // 删除 i
                    dp(word1, i - 1, word2, j - 1)) + 1; // 把 i 更新成j
                    // 注意加 1
            }
            return memo[i][j];
        }


        int min(int a, int b, int c) {
            return Math.min(Math.min(a, b), c);
        }


    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// "horse"\n"ros"\n
// @lcpr case=end

// @lcpr case=start
// "intention"\n"execution"\n
// @lcpr case=end

 */

