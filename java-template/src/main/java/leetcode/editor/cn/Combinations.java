/*
 * @lc app=leetcode.cn id=77 lang=java
 * @lcpr version=30403
 *
 * [77] 组合
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class Combinations {

    // @lc code=start
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<Integer> path = new LinkedList<>();
            backtrack(n, path, k, 1);
            return res;
        }
        List<List<Integer>> res = new LinkedList<>();

        void backtrack(int n, List<Integer> path, int k, int start) {
            if (path.size() == k) {
                res.add(new LinkedList<>(path));
                //提前结束递归
                return;
            }

            for(int i = start; i <= n; i++) {
                // 做选择
                path.addLast(i);

                backtrack(n, path, k, i + 1);

                // 撤销选择
                path.removeLast();
            }

        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// 4\n2\n
// @lcpr case=end

// @lcpr case=start
// 1\n1\n
// @lcpr case=end

 */

