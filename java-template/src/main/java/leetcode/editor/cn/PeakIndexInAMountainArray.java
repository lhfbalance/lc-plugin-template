/*
 * @lc app=leetcode.cn id=852 lang=java
 * @lcpr version=30403
 *
 * [852] 山脉数组的峰顶索引
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class PeakIndexInAMountainArray {

    // @lc code=start
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int left = 0;
            int right = arr.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // mid+1 <= right，所以不会越界
                if (arr[mid] > arr[mid + 1]) {
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
        Solution solution = new PeakIndexInAMountainArray().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [0,1,0]\n
// @lcpr case=end

// @lcpr case=start
// [0,2,1,0]\n
// @lcpr case=end

// @lcpr case=start
// [0,10,5,2]\n
// @lcpr case=end

 */

