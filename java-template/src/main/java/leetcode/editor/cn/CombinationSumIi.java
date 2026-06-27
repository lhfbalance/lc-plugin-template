/*
 * @lc app=leetcode.cn id=40 lang=java
 * @lcpr version=30403
 *
 * [40] 组合总和 II
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class CombinationSumIi {

    // @lc code=start
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<Integer> path = new LinkedList<>();
            backtrack(candidates, path, 0, 0, target);
            return res;
            
        }

        List<List<Integer>> res = new LinkedList<>();

        void backtrack(int[] candidates, List<Integer> path, int sum, int start, int target) {
            if(sum == target) {
                res.add(new LinkedList<>(path));
                return;
            }
            if (sum > target) {
                // 剪枝
                return;
            }

            for(int i = start ; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    // 剪枝，值相同的相邻树枝遍历一次即可
                    continue;
                }
                path.addLast(candidates[i]);
                sum += candidates[i];

                backtrack(candidates, path, sum, i + 1, target);

                path.removeLast();
                sum -= candidates[i];
            }
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [10,1,2,7,6,1,5]\n8\n
// @lcpr case=end

// @lcpr case=start
// [2,5,2,1,2]\n5\n
// @lcpr case=end

 */

