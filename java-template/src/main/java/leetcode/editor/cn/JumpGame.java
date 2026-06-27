/*
 * @lc app=leetcode.cn id=55 lang=java
 * @lcpr version=30403
 *
 * [55] 跳跃游戏
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class JumpGame {

    // @lc code=start
    class Solution {
        public boolean canJump(int[] nums) {

            if (nums.length == 1) {
                return true;
            }
            int fastest = 0;
            for(int i = 0; i < nums.length; i++) {
                fastest = Math.max(fastest, i + nums[i]);
                if (fastest >= nums.length - 1) {
                    return true;
                }
                // 碰到 0，卡主不动了
                if (fastest == i) {
                    return false;
                }
            }
            return false;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [2,3,1,1,4]\n
// @lcpr case=end

// @lcpr case=start
// [3,2,1,0,4]\n
// @lcpr case=end

 */

