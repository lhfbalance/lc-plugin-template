/*
 * @lc app=leetcode.cn id=1 lang=java
 * @lcpr version=30403
 *
 * [1] 两数之和
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class TwoSum {

    // @lc code=start
    class Solution {
        public int[] twoSum(int[] nums, int target) {

            // 数字和其下标的映射
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                int diff = target - nums[i];
                if (map.containsKey(diff)) {
                    return new int[] {map.get(diff), i};
                }
                map.put(nums[i], i);
            }
            return null;
            
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [2,7,11,15]\n9\n
// @lcpr case=end

// @lcpr case=start
// [3,2,4]\n6\n
// @lcpr case=end

// @lcpr case=start
// [3,3]\n6\n
// @lcpr case=end

 */

