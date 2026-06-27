/*
 * @lc app=leetcode.cn id=139 lang=java
 * @lcpr version=30403
 *
 * [139] 单词拆分
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class WordBreak {

    // @lc code=start
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int n = s.length();
            boolean dp[] = new boolean[n + 1];
            dp[n] = true;
            for(int i = n - 1; i >= 0; i--) {
                for(String word : wordDict) {
                    if (i + word.length() <= n && word.equals(s.substring(i, i + word.length()))) {
                        dp[i] = dp[i] || dp[i + word.length()];
                    }
                }
            }
            return dp[0];
        }

        public boolean wordBreak1(String s, List<String> wordDict) {
            // 状态，字符串的索引
            // 选择，字符串列表中的字符串选或不选
            // 状态转移方程的定义
            // 状态转移逻辑
            memo = new int[s.length()];
            Arrays.fill(memo, -1);
            return dp(s, wordDict, 0);
            
        }
        int[] memo;
        boolean dp(String s, List<String> wordDict, int start) {
            if (start == s.length()) {
                return true;
            }
            if (start > s.length()) {
                return false;
            }
            if (memo[start] != -1) {
                return memo[start] == 1 ? true : false;
            }
            boolean res = false;
            // for(int i = 1; start + i <= s.length() ; i++) {
            //     if (wordDict.contains(s.substring(start, start + i))) {
            //         res = res || dp(s, wordDict, start + i);
            //         if (res) {
            //             // 直接终止
            //             return true;
            //         }
            //     }
            // }
            for(String word : wordDict) {
                if (start + word.length() <= s.length() && word.equals(s.substring(start, start + word.length()))) {
                    res = res || dp(s, wordDict, start + word.length());
                    if (res) {
                        // 直接终止
                        return true;
                    }
                }
            }
            memo[start] = res ? 1: 0;
            return res;

        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// "leetcode"\n["leet","code"]\n
// @lcpr case=end

// @lcpr case=start
// "applepenapple"\n["apple","pen"]\n
// @lcpr case=end

// @lcpr case=start
// "catsandog"\n["cats","dog","sand","and","cat"]\n
// @lcpr case=end

 */

