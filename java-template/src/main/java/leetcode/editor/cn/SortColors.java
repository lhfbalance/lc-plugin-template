/*
 * @lc app=leetcode.cn id=75 lang=java
 * @lcpr version=30403
 *
 * [75] 颜色分类
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SortColors {

    // @lc code=start
    class Solution {
        public void sortColors(int[] nums) {

            // int[] colors = new int[3];
            // for(int i = 0; i < nums.length; i++) {
            //     colors[nums[i]]++;
            // }
            int left = 0;
            int right = nums.length - 1;
            int i = 0;
            while (i <= right) {
                if (nums[i] == 0) {
                    if (i != left) {
                        swap(nums, i, left);
                    }
                    left++;
                    i++;
                } else if (nums[i] == 1) {
                    i++;
                } else if (nums[i] == 2) {
                    swap(nums, i, right);
                    right--;
                }
            }
            
        }

        void swap(int[] nums, int i1, int i2) {
            int temp = nums[i1];
            nums[i1] = nums[i2];
            nums[i2] = temp;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
        int[] colors = {0,2,1};
        solution.sortColors(colors);
        // put your test code here

    }
}



/*
// @lcpr case=start
// [2,0,2,1,1,0]\n
// @lcpr case=end

// @lcpr case=start
// [2,0,1]\n
// @lcpr case=end

 */

