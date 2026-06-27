/*
 * @lc app=leetcode.cn id=140 lang=java
 * @lcpr version=30403
 *
 * [140] 单词拆分 II
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class WordBreakIi {

    // @lc code=start
    class Solution {
        @SuppressWarnings("unchecked")
        public List<String> wordBreak(String s, List<String> wordDict) {
            memo = new LinkedList[s.length()];
            return dp(s, wordDict, 0);
        }

        List<String>[] memo;
        List<String> dp(String s, List<String> wordDict, int i) {
            List<String> res = new LinkedList<>();
            if (i == s.length()) {
                res.add("");
                return res;
            }

            if (memo[i] != null) {
                return memo[i];
            }

            for(String word : wordDict) {
                if (i + word.length() <= s.length() && word.equals(s.substring(i, i + word.length()))) {
                   List<String> subRes = dp(s, wordDict, i + word.length());
                   for(String sub : subRes) {
                        if (sub != "") {
                            res.add(word + " " + sub);    
                        } else {
                            res.add(word);
                        }
                        
                   }
                }
            }
            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new WordBreakIi().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// "catsanddog"\n["cat","cats","and","sand","dog"]\n
// @lcpr case=end

// @lcpr case=start
// "pineapplepenapple"\n["apple","pen","applepen","pine","pineapple"]\n
// @lcpr case=end

// @lcpr case=start
// "catsandog"\n["cats","dog","sand","and","cat"]\n
// @lcpr case=end

 */

