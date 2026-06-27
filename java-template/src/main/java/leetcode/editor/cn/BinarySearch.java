/*
 * @lc app=leetcode.cn id=704 lang=java
 * @lcpr version=30403
 *
 * [704] 二分查找
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class BinarySearch {

    // @lc code=start
    class Solution {
        public int search(int[] nums, int target) {

            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid]  == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
            return -1;
            
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [-1,0,3,5,9,12]\n9\n
// @lcpr case=end

// @lcpr case=start
// [-1,0,3,5,9,12]\n2\n
// @lcpr case=end

 */

