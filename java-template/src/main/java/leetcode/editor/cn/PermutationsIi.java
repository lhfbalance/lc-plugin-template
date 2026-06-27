/*
 * @lc app=leetcode.cn id=47 lang=java
 * @lcpr version=30403
 *
 * [47] 全排列 II
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class PermutationsIi {

    // @lc code=start
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        public List<List<Integer>> permuteUnique(int[] nums) {

            boolean[] used = new boolean[nums.length];
            Arrays.sort(nums);
            backtrack(nums, used);
            return res;
            
        }
        void backtrack(int[] nums, boolean[] used) {
            if (path.size() == nums.length) {
                res.add(new LinkedList<>(path));
                return;
            }

            for(int i = 0; i < nums.length; i++) {
                // 去除已选
                if (used[i]) {
                    continue;
                }
                // 剪枝
                if (i > 0 && nums[i] == nums [i-1] && !used[i - 1]) {
                    continue;
                }
                
                path.addLast(nums[i]);
                used[i] = true;

                backtrack(nums, used);

                used[i] = false;
                path.removeLast();
            }
        }
        
        
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,1,2]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

 */

