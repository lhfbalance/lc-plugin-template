/*
 * @lc app=leetcode.cn id=162 lang=java
 * @lcpr version=30403
 *
 * [162] 寻找峰值
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class FindPeakElement {

    // @lc code=start
    class Solution {
        public int findPeakElement(int[] nums) {
            
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // mid+1 <= right，所以不会越界
                if (nums[mid] > nums[mid + 1]) {
                    // 如果 nums[mid] > nums[mid+1] 则说明 nums[mid]本身是峰值，或者峰值在 nums[mid]的左侧
                    right = mid;
                } else {
                    //峰值在 nums[mid]的右侧
                    left = mid + 1;
                }
                // 题目中说了nums[i] != nums[i + 1]
            }
            // 结束循环的条件是 left = right，就是峰值

            return left;
            
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new FindPeakElement().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,2,3,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,1,3,5,6,4]\n
// @lcpr case=end

 */

