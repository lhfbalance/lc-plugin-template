/*
 * @lc app=leetcode.cn id=35 lang=java
 * @lcpr version=30403
 *
 * [35] 搜索插入位置
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SearchInsertPosition {

    // @lc code=start
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] == target) {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,3,5,6]\n5\n
// @lcpr case=end

// @lcpr case=start
// [1,3,5,6]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1,3,5,6]\n7\n
// @lcpr case=end

 */

