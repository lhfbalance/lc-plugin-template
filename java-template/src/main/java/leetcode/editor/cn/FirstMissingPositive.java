/*
 * @lc app=leetcode.cn id=41 lang=java
 * @lcpr version=30403
 *
 * [41] 缺失的第一个正数
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class FirstMissingPositive {

    // @lc code=start
    class Solution {
        public int firstMissingPositive(int[] nums) {
            // 缺失的最小正数一定是[1..n+1]之间的数，数组里是有负数的
            // 要 O(n)的时间复杂度，那就不能排序了
            // 常数级别的空间--
            int n = nums.length;
            for(int i = 0; i < n; i++) {
                if (nums[i] <= 0 || nums[i] > n) {
                    nums[i] = n + 1;
                }
            }
            // 将值与数组下标映射，因为 0 不是正数，所以有一位的错位
            // 用数组下标的值对应的符号位，来记录对应正数是否出现过
            for(int i = 0; i < n; i++) {
                // nums[i]有可能已经是负数了，所以要取绝对值（比如[0,1,-1,-1]
                int x = Math.abs(nums[i]);
                if (x <= n) {
                    int temp = Math.abs(nums[x-1]);
                    nums[x-1] = -temp;
                }
            }

            for(int i = 0; i < n; i++) { 
                if (nums[i] > 0) {
                    return i + 1;
                }
            }
            return n+1;
            
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
        int[] arr = {3,4,-1,1};
        solution.firstMissingPositive(arr);
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,2,0]\n
// @lcpr case=end

// @lcpr case=start
// [3,4,-1,1]\n
// @lcpr case=end

// @lcpr case=start
// [7,8,9,11,12]\n
// @lcpr case=end

 */

