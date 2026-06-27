/*
 * @lc app=leetcode.cn id=80 lang=java
 * @lcpr version=30403
 *
 * [80] 删除有序数组中的重复项 II
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RemoveDuplicatesFromSortedArrayIi {

    // @lc code=start
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length < 2) {
                return nums.length;
            }
            int slow = 0;
            int fast = 0;
            int count = 0;
            while (fast < nums.length) {
                if (nums[slow] != nums[fast]) {
                    slow++;
                    nums[slow] = nums[fast];
                } else if (slow < fast && count < 2){
                    // 这里为什么要加一个 slow<fast的条件呢，初始时 slow 和 fast 均为 0
                    // 让 fast 先走一步
                    slow ++;
                    nums[slow] = nums[fast];
                } 
                fast ++;
                count ++;
                if (fast < nums.length && nums[fast] != nums[fast-1]) {
                    count = 0;
                }
            }

            return slow + 1;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArrayIi().new Solution();
        // put your test code here
        int[] testCase = {1,1,1,2,2,3};
        solution.removeDuplicates(testCase);

    }
}



/*
// @lcpr case=start
// [1,1,1,2,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [0,0,1,1,1,1,2,3,3]\n
// @lcpr case=end

 */

