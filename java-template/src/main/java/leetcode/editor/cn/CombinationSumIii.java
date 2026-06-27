/*
 * @lc app=leetcode.cn id=216 lang=java
 * @lcpr version=30403
 *
 * [216] 组合总和 III
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class CombinationSumIii {

    // @lc code=start
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        int sum = 0;
        public List<List<Integer>> combinationSum3(int k, int n) {
            backtrack(k, n, 1);
            return res;
        }

        void backtrack(int k, int n, int start) {
            if (path.size() == k && sum == n) {
                res.add(new LinkedList<>(path));
                return;
            }
            if (path.size() > k || sum > n) {
                return;
            }

            for(int i = start; i <= 9; i++) {
                path.addLast(i);
                sum += i;

                backtrack(k, n, i + 1);

                sum -= i;
                path.removeLast();
            }
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new CombinationSumIii().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// 3\n7\n
// @lcpr case=end

// @lcpr case=start
// 3\n9\n
// @lcpr case=end

// @lcpr case=start
// 4\n1\n
// @lcpr case=end

 */

