/*
 * @lc app=leetcode.cn id=81 lang=java
 * @lcpr version=30403
 *
 * [81] 搜索旋转排序数组 II
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SearchInRotatedSortedArrayIi {

    // @lc code=start
    class Solution {
        public boolean search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                // 先对左右边界去重，避免 num[mid] 和左右边界相等，导致无法判断 mid 的位置
                while (left < right && nums[left] == nums[left+1]) {
                    left ++ ;
                }
                // 先对左右边界去重，避免 num[mid] 和左右边界相等，导致无法判断 mid 的位置
                while (right > left && nums[right] == nums[right - 1]) {
                    right --;
                }
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return true;
                }
                if (nums[mid] > nums[right]) {
                    // left...mid 是递增的，判断 target 在这个范围时，可把右边界缩小过来
                    if (target >= nums[left] && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                    
                } else {
                    // mid...right 是递增的，判断 target 在这个范围时，可把左边界缩小过来
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }

                }
                
            }

            return false;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArrayIi().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [2,5,6,0,0,1,2]\n0\n
// @lcpr case=end

// @lcpr case=start
// [2,5,6,0,0,1,2]\n3\n
// @lcpr case=end

 */

