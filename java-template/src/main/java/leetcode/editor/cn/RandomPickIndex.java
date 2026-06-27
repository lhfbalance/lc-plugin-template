/*
 * @lc app=leetcode.cn id=398 lang=java
 * @lcpr version=30403
 *
 * [398] 随机数索引
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RandomPickIndex {

    // @lc code=start
    class Solution {

        int[] nums;
        Random random;
    public Solution() {}
        public Solution(int[] nums) {
            this.nums = nums;
            this.random = new Random();
        }
        
        public int pick(int target) {
            // 计数有 i 个和 target 相等的值
            int count = 0;
            int res = -1;
            for(int i = 0; i < nums.length; i++) {
                if (nums[i] != target) {
                    continue;
                }
                count++;
                // 动态随机，要不要选择当前这个值
                int r = random.nextInt(count);
                if (r == 0) {
                    res = i;
                }
            }
            return res;
        }
    }
    
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int param_1 = obj.pick(target);
     */
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new RandomPickIndex().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// ["Solution","pick","pick","pick"]\n[[[1,2,3,3,3]],[3],[1],[3]]\n
// @lcpr case=end

 */

