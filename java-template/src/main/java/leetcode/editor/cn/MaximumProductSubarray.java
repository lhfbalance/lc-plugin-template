/*
 * @lc app=leetcode.cn id=152 lang=java
 * @lcpr version=30403
 *
 * [152] 乘积最大子数组
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MaximumProductSubarray {

    // @lc code=start
    class Solution {

        public int maxProduct(int[] nums) {

            // 以 nums[i]结尾的的最大子数组可能有几种情况
            // 1.nums[i-1] 和 nums[i]
            // 2.nums[i] 自己

            // 以 nums[i]结尾的的最小子数组可能有几种情况
            // 1.nums[i-1] 和 nums[i]
            // 2.nums[i] 自己

            // 以 nums[i]结尾的的最大子数组乘积
            int max;
            // 以 nums[i]结尾的的最小子数组乘积，用来考虑有符号反转情况
            int min;
            max = nums[0];
            min = nums[0];
            int res = max;
            for(int i = 1; i < nums.length; i++) {
                int preMax = max;
                max =  max(preMax * nums[i], nums[i], min * nums[i]);
                min = min(min * nums[i], nums[i], preMax * nums[i]);
                res = Math.max(res, max);
            }
            return res;
            
        }

        

        public int maxProduct1(int[] nums) {

            // 以 nums[i]结尾的的最大子数组可能有几种情况
            // 1.nums[i-1] 和 nums[i]
            // 2.nums[i] 自己

            // 以 nums[i]结尾的的最小子数组可能有几种情况
            // 1.nums[i-1] 和 nums[i]
            // 2.nums[i] 自己

            // 以 nums[i]结尾的的最大子数组乘积
            int[] dp1= new int[nums.length];
            // 以 nums[i]结尾的的最小子数组乘积，用来考虑有符号反转情况
            int[] dp2= new int[nums.length];
            dp1[0] = nums[0];
            dp2[0] = nums[0];

            int res = nums[0];

            for(int i = 1; i < nums.length; i++) {
                dp1[i] =  max(dp1[i-1] * nums[i], nums[i], dp2[i-1] * nums[i]);
                dp2[i] = min(dp2[i-1] * nums[i], nums[i], dp1[i-1] * nums[i]);
                res = Math.max(res, dp1[i]);
            }
            return res;
            
        }

        int min(int a, int b, int c) {
            return Math.min(Math.min(a, b), c);
        }

        int max(int a, int b, int c) {
            return Math.max(Math.max(a, b), c);
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [2,3,-2,4]\n
// @lcpr case=end

// @lcpr case=start
// [-2,0,-1]\n
// @lcpr case=end

 */

