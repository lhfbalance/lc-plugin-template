/*
 * @lc app=leetcode.cn id=22 lang=java
 * @lcpr version=30403
 *
 * [22] 括号生成
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class GenerateParentheses {

    // @lc code=start
    class Solution {
        List<String> res = new LinkedList<>();
        StringBuilder path = new StringBuilder();
        public List<String> generateParenthesis(int n) {
            backtrack(n, n);
            return res;
        }
        // left 左括号的剩余数量，right 右括号的剩余数量
        void backtrack(int left, int right) {
            if (left == 0 && right == 0) {
                // 到达叶子节点
                res.add(path.toString());
                return ;
            }
            // left 剩余数量大于 right 也是不合法的
            if (left < 0 || right < 0 || left > right) {
                return;
            }

            path.append("(");
            backtrack(left - 1, right);
            path.deleteCharAt(path.length() - 1);

            path.append(")");
            backtrack(left, right - 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        solution.generateParenthesis(3);
        // put your test code here

    }
}



/*
// @lcpr case=start
// 3\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

