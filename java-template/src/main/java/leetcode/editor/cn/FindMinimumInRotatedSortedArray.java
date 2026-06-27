/*
 * @lc app=leetcode.cn id=153 lang=java
 * @lcpr version=30403
 *
 * [153] 寻找旋转排序数组中的最小值
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class FindMinimumInRotatedSortedArray {

    // @lc code=start
    class Solution {
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[right]) {
                    left = mid + 1; 
                } else {
                    // mid 有可能就是最小索引
                    right = mid;
                }
            }
            return nums[left];
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
        int[] arr = {3,1,2};
        solution.findMin(arr);
        // put your test code here

    }
}



/*
// @lcpr case=start
// [3,4,5,1,2]\n
// @lcpr case=end

// @lcpr case=start
// [4,5,6,7,0,1,2]\n
// @lcpr case=end

// @lcpr case=start
// [11,13,15,17]\n
// @lcpr case=end

 */

