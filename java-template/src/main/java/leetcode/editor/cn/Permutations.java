/*
 * @lc app=leetcode.cn id=46 lang=java
 * @lcpr version=30403
 *
 * [46] 全排列
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class Permutations {

    // @lc code=start
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            this.nums = nums;
            this.used = new boolean[nums.length];

            List<Integer> path = new LinkedList<>();
            backtrack(path, 0);

            return res;
        }
        List<List<Integer>> res = new LinkedList<>();
        int[] nums;
        boolean[] used;
        void backtrack(List<Integer> path, int n) {
            if (n == nums.length) {
                // 到达叶子节点
                res.add(new LinkedList<>(path));
                return;
            }

            for(int i = 0; i< nums.length; i++) {
                if (used[i]) {
                    continue;
                }

                // 做选择
                path.addLast(nums[i]);
                used[i] = true;

                // 递归
                backtrack(path, n + 1);

                // 撤销选择
                path.removeLast();
                used[i] = false;

            }

        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [0,1]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

