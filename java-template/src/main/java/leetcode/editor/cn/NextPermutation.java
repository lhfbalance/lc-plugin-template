/*
 * @lc app=leetcode.cn id=31 lang=java
 * @lcpr version=30403
 *
 * [31] 下一个排列
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class NextPermutation {

    // @lc code=start
    class Solution {
        public void nextPermutation(int[] nums) {
            if (nums.length <= 1) {
                return;
            }
            
            
            // 从右至左找到第一个不满足递减的数
            int i = nums.length - 2;
            while ( i>=0 && nums[i] >= nums[i+1]) {
                i--;
            }
            if (i >= 0) {
               // i++...是递减的序列
                int j = nums.length - 1;
                // 找到第一个 大于 i 的索引
                while (i >= 0 && j > i && nums[j] <= nums[i]) {
                    j--;
                }
            
                // 此时 nums[j] > nums[i], 但交换后不会改变 i++的递减序列特性
                swap(nums, i, j);
            
            }
            // 此时 i++还是递减的
            reverse(nums, i + 1, nums.length - 1);
            
        }

        void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // 反正 nums 中从元素 i 到元素 j;1,2,5,3,2,3
        void reverse(int[] nums, int p, int q) {
            while (p < q) {
                swap(nums, p, q);
                p++;
                q--;
            }
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        int[] arr = {1,2,3};
        solution.nextPermutation(arr);
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [3,2,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,1,5]\n
// @lcpr case=end

 */

