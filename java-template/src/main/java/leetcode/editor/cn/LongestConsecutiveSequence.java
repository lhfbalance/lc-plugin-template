/*
 * @lc app=leetcode.cn id=128 lang=java
 * @lcpr version=30403
 *
 * [128] 最长连续序列
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class LongestConsecutiveSequence {

    // @lc code=start
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < nums.length ; i++) {
                set.add(nums[i]);
            }
            int res = 0;

            // 这里对 set 遍历，set 会去重，另外也会打乱 nums 的顺序
            for(int num : set) {
                if (set.contains(num - 1)) {
                    continue;
                }
                int j = 0;
                int length = 0;
                while (set.contains(num + j)) {
                    length ++;
                    j++;
                }
                res = Math.max(res, length);
            }
            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [100,4,200,1,3,2]\n
// @lcpr case=end

// @lcpr case=start
// [0,3,7,2,5,8,4,6,0,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,0,1,2]\n
// @lcpr case=end

 */

