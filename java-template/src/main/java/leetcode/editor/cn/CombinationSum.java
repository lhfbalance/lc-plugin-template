/*
 * @lc app=leetcode.cn id=39 lang=java
 * @lcpr version=30403
 *
 * [39] 组合总和
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class CombinationSum {

    // @lc code=start
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        int sum = 0;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            backtrack(candidates, target, 0);
            return res;
        }

        void backtrack(int[] candidates, int target, int start) {
            if (sum == target) {
                res.add(new LinkedList<>(path));
                // 直接停止
                return ;
            }
            if (sum > target) {
                // 没必要再递归了
                return ;
            }

            for(int i = start; i < candidates.length; i++) {
                path.addLast(candidates[i]);
                sum += candidates[i];
                // 让下一层还从 i 开始而不是 i+1，这样就能保证单个元素可以重复使用
                // 相当于每一层多了一个树枝
                backtrack(candidates, target, i);

                sum -= candidates[i];
                path.removeLast();
            }   

        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [2,3,6,7]\n7\n
// @lcpr case=end

// @lcpr case=start
// [2,3,5]\n8\n
// @lcpr case=end

// @lcpr case=start
// [2]\n1\n
// @lcpr case=end

 */

