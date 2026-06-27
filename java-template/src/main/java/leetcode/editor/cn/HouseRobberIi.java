/*
 * @lc app=leetcode.cn id=213 lang=java
 * @lcpr version=30403
 *
 * [213] 打家劫舍 II
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class HouseRobberIi {

    // @lc code=start
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return nums[0];
            }
            return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
        }

        public int rob(int[] nums, int start, int end) {
            int dpi2 = 0;
            int dpi1 = 0;
            int dpi = 0;
            for(int i = end; i >= start; i--) {
                dpi = Math.max(dpi1, nums[i] + dpi2);
                dpi2 = dpi1;
                dpi1 = dpi;
            }
            return dpi;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new HouseRobberIi().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [2,3,2]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

 */

