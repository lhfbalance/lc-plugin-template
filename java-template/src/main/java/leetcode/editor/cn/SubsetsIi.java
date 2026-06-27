/*
 * @lc app=leetcode.cn id=90 lang=java
 * @lcpr version=30403
 *
 * [90] 子集 II
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SubsetsIi {

    // @lc code=start
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<Integer> path = new LinkedList<>();
            // 排序，为剪枝做准备
            Arrays.sort(nums);
            backtrack(nums, path, 0);
            return res;
        }

        List<List<Integer>> res = new LinkedList<>();

        void backtrack(int[] nums, List<Integer> path, int start) {
            // 每个节点都要
            res.add(new LinkedList<>(path));

            // for 循环包含了结束条件
            // start 控制了树枝的生长，保证不会有重复
            for(int i = start; i < nums.length; i++) {
                // 增加剪枝逻辑，值相同的相邻树枝，只遍历一条即可
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                // 选择
                path.addLast(nums[i]);
                
                backtrack(nums, path, i + 1);
                // 撤销选择
                path.removeLast();
                
            }

        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,2,2]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

 */

