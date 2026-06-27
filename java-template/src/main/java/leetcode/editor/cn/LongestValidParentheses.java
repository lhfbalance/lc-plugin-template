/*
 * @lc app=leetcode.cn id=32 lang=java
 * @lcpr version=30403
 *
 * [32] 最长有效括号
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class LongestValidParentheses {

    // @lc code=start
    class Solution {

        public int longestValidParentheses(String s) {
            int[] dp = new int[s.length() + 1];
            // dp[i+1] 是 以s.charAt(i) 结尾的最长有效括号子串的长度
            
            Stack<Integer> cStack = new Stack<>();
            int res = 0;
            for(int i = 0; i < s.length(); i++) {
                Character c = s.charAt(i);
                if (c == '(') {
                    // 左括号
                    cStack.push(i);
                    dp[i + 1] = 0;
                } else {
                    // 右括号
                    if (!cStack.isEmpty()) {
                        int leftIndex = cStack.pop();
                        // 新的子串
                        dp[i + 1] = i - leftIndex + 1 + dp[leftIndex];

                    } else {
                        // 左边没有左括号
                        dp[i + 1] = 0;
                    }
                }
                res = Math.max(res, dp[i + 1]);
            }
            return res;
        }

        public int longestValidParentheses1(String s) {
            int[] dp = new int[s.length() + 1];
            // dp[i] 是 以s.charAt(i-1) 结尾的最长有效括号子串的长度
            
            Stack<Integer> cStack = new Stack<>();
            int res = 0;
            for(int i = 1; i < s.length() + 1; i++) {
                Character c = s.charAt(i - 1);
                if (c == '(') {
                    // 左括号
                    cStack.push(i-1);
                    dp[i] = 0;
                } else {
                    // 右括号
                    if (!cStack.isEmpty()) {
                        int leftIndex = cStack.pop();
                        // 新的子串
                        dp[i] = (i - 1) - leftIndex + 1 + dp[leftIndex];

                    } else {
                        // 左边没有左括号
                        dp[i] = 0;
                    }
                }
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// "(()"\n
// @lcpr case=end

// @lcpr case=start
// ")()())"\n
// @lcpr case=end

// @lcpr case=start
// ""\n
// @lcpr case=end

 */

