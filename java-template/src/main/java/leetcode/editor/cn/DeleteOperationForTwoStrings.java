/*
 * @lc app=leetcode.cn id=583 lang=java
 * @lcpr version=30403
 *
 * [583] 两个字符串的删除操作
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class DeleteOperationForTwoStrings {

    // @lc code=start
    class Solution {
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
          
            for(int i = 1; i <=word1.length(); i++) {

                for(int j = 1; j<=word2.length();j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }

            }
            return word1.length() + word2.length() - dp[word1.length()][word2.length()] * 2;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new DeleteOperationForTwoStrings().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// "sea"\n"eat"\n
// @lcpr case=end

// @lcpr case=start
// "leetcode"\n"etco"\n
// @lcpr case=end

 */

