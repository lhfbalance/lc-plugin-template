/*
 * @lc app=leetcode.cn id=136 lang=java
 * @lcpr version=30403
 *
 * [136] 只出现一次的数字
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SingleNumber {

    // @lc code=start
    class Solution {
        public int singleNumber(int[] nums) {
            int res = 0;
            for(int i = 0; i< nums.length; i++) {
                // 任何数与零异或还是本身
                // 与自己异或为 0
                res = res^nums[i];
            }
            return res;
            
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [2,2,1]\n
// @lcpr case=end

// @lcpr case=start
// [4,1,2,1,2]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

