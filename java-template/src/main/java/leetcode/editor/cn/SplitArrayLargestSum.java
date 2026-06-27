/*
 * @lc app=leetcode.cn id=410 lang=java
 * @lcpr version=30403
 *
 * [410] 分割数组的最大值
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SplitArrayLargestSum {

    // @lc code=start
    class Solution {
        public int splitArray(int[] nums, int k) {

            int left = 0;
            int right = 0;

            for(int i=0; i<nums.length; i++) {
                left = Math.max(left, nums[i]);
                right = right + nums[i];
            }

            // 最大值最小，其实就是左边界
            while (left <= right) {
                int mid = left + (right - left)/2;
                int n = splitN(nums, mid);
                if (n == k) {
                     right = mid - 1;
                } else if(n < k) {
                     right = mid - 1;
                } else if (n > k) {
                    left = mid + 1;
                }
            }
            return left;

            
        }

        // 单调递减函数,随着 maxsum 增大，组数就会越小
        public int splitN(int[] nums, int maxSum) {
            int res = 0;
            int i = 0;
            while (i < nums.length) {
                int capacity = maxSum;

                while (i < nums.length) {
                    if (capacity >= nums[i]) {
                        // 可以继续分割
                        capacity = capacity - nums[i];
                        i++;
                    } else {
                        // 不能再分割了
                        break;
                    }
                }
                res++;
            }
            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new SplitArrayLargestSum().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [7,2,5,10,8]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5]\n2\n
// @lcpr case=end

 */

