/*
 * @lc app=leetcode.cn id=33 lang=java
 * @lcpr version=30403
 *
 * [33] 搜索旋转排序数组
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SearchInRotatedSortedArray {

    // @lc code=start
    class Solution {
        public int search(int[] nums, int target) {

            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
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

            return -1;
            
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [4,5,6,7,0,1,2]\n0\n
// @lcpr case=end

// @lcpr case=start
// [4,5,6,7,0,1,2]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1]\n0\n
// @lcpr case=end

 */

