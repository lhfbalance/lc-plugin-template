/*
 * @lc app=leetcode.cn id=4 lang=java
 * @lcpr version=30403
 *
 * [4] 寻找两个正序数组的中位数
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MedianOfTwoSortedArrays {

    // @lc code=start
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // 为奇数是，中位数的下标是 length / 2
            // 为偶数时，中位数的下标是 length / 2 - 1, length / 2 
            int pre = 0;
            int cur = 0;
            int midIndex = (nums1.length + nums2.length) / 2;
            int i = 0; int j = 0;
            for(int k = 0; k <= midIndex; k++) {
                pre = cur;
                if (i < nums1.length && (j >= nums2.length || nums1[i] < nums2[j])) {
                    cur = nums1[i];
                    i++;
                } else {
                    cur = nums2[j];
                    j++;
                }
            }

            if ((nums1.length + nums2.length) % 2 == 0) {
                return (pre + cur) / 2.0d;
            } else {
                return cur;
            }
            

        }
        public double findMedianSortedArrays1(int[] nums1, int[] nums2) {

            
            int[] nums = mergeArrary(nums1, nums2);
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                left++;
                right--;
            }
            return (nums[left] + nums[right]) / 2.0d;
            
        }

        int[] mergeArrary(int[] nums1, int[] nums2) {
            int i = 0;
            int j = 0;
            int k = 0;
            int[] res = new int[nums1.length + nums2.length];
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    res[k] = nums1[i];
                    i++;
                } else {
                    res[k] = nums2[j];
                    j++;
                }
                k++;
            }
            while (i < nums1.length) {
                res[k] = nums1[i];
                i++;
                k++;
            }
            while (j < nums2.length) {
                res[k] = nums2[j];
                j++;
                k++;
            }
            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,3]\n[2]\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n[3,4]\n
// @lcpr case=end

 */

