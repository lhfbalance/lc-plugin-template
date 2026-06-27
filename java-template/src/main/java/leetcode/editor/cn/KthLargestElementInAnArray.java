/*
 * @lc app=leetcode.cn id=215 lang=java
 * @lcpr version=30403
 *
 * [215] 数组中的第K个最大元素
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class KthLargestElementInAnArray {

    // @lc code=start
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            shuffle(nums);
            int nk = nums.length - k;
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int pivot = partition(nums, start, end);
                if (pivot > nk) {
                    end = pivot - 1;
                } else if (pivot < nk) {
                    start = pivot + 1;
                } else if (pivot == nk) {
                    return nums[pivot];
                }
            }
            return 0;
        }

        public int partition(int[] nums, int lo, int hi) {
            int pivot = lo;
            // [lo+1,i) --起始是空的
            int i = lo + 1;
            // (j, hi] --起始是空的
            int j = hi;
            // 当 i>j的时候退出循环，确保每个元素都被遍历
            while (i <= j) {
                while (i < hi && nums[i] <= nums[pivot]) {
                    i++;
                }
                while (j > lo && nums[j] > nums[pivot]) {
                    j--;
                }
                if (i >= j) {
                    break;
                }
                swap(nums, i, j);
            }
            // 这里一定是跟j 交换，povit在最左边， nums[j] 是满足小于nums[povit]
            // j 也一定不会越界，i 是有可能越界的
            swap(nums, pivot, j);
            return j;
        }
        void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        void shuffle(int[] nums) {
            Random random = new Random();
            int n = nums.length;
            for(int i = 0; i < n; i++) {
                int r = random.nextInt(i, n);
                swap(nums, i, r);
            }
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [3,2,1,5,6,4]\n2\n
// @lcpr case=end

// @lcpr case=start
// [3,2,3,1,2,4,5,5,6]\n4\n
// @lcpr case=end

 */

