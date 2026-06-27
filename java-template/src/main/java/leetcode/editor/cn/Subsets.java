/*
 * @lc app=leetcode.cn id=78 lang=java
 * @lcpr version=30403
 *
 * [78] 子集
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class Subsets {

    // @lc code=start
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<Integer> path = new LinkedList<>();
            
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
        Solution solution = new Subsets().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

 */

