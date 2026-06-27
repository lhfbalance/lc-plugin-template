/*
 * @lc app=leetcode.cn id=131 lang=java
 * @lcpr version=30403
 *
 * [131] 分割回文串
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class PalindromePartitioning {

    // @lc code=start
    class Solution {
        List<List<String>> res = new LinkedList<>();
        List<String> path = new LinkedList<>();
        public List<List<String>> partition(String s) {
            backtrack(s, 0);
            return res;
        }

        void backtrack(String s, int start) {
            if (start == s.length()) {
                // 到达叶子节点
                res.add(new LinkedList<>(path));
                return;
            }

            // 可选择的路径是截取子串的长度，从 1 到
            for(int i = 1; i <= (s.length() - start); i++) {
                String sub = s.substring(start, start + i);
                if (!isHuiwen(sub)) {
                    continue;
                }
                path.addLast(sub);

                backtrack(s, start + i);

                path.removeLast();
            }
        }

        boolean isHuiwen(String s) {
            int left = 0;
            int right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left ++;
                right --;
            }
            return true;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
        solution.partition("aab");
        // put your test code here
        System.out.println(solution.isHuiwen("1"));

    }
}



/*
// @lcpr case=start
// "aab"\n
// @lcpr case=end

// @lcpr case=start
// "a"\n
// @lcpr case=end

 */

