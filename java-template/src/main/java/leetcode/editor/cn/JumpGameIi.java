/*
 * @lc app=leetcode.cn id=45 lang=java
 * @lcpr version=30403
 *
 * [45] 跳跃游戏 II
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class JumpGameIi {

    // @lc code=start
    class Solution {
        public int jump(int[] nums) {
            int step = 0;
            int fast = 0;
            if (nums.length == 1) {
                return 0;
            }

            
            int end = 0;
            for(int i = 0; i < nums.length; i++) {
                
                fast = Math.max(fast, i + nums[i]);
                if (i == end) {
                    // 到达本次可起跳范围的终点（上次跳跃的可选范围）
                    // 在本次起跳范围内能跳到的最远值
                    end = fast;
                    // 再跳一次
                    step++;
                }
                // 本次可跳的最远距离已经超过终点，直接结束
                if (end >= nums.length - 1) {
                    return step;
                }
                
            }
            // 严谨些
            return -1;
            
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [2,3,1,1,4]\n
// @lcpr case=end

// @lcpr case=start
// [2,3,0,1,4]\n
// @lcpr case=end

 */

