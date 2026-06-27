/*
 * @lc app=leetcode.cn id=42 lang=java
 * @lcpr version=30403
 *
 * [42] 接雨水
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class TrappingRainWater {

    // @lc code=start
    class Solution {

        // 双指针解法，边走边算
        public int trap(int[] height) {

            int n = height.length;
            int lmax = height[0];
            int rmax = height[n - 1];
            int left = 0;
            int right = n - 1;
            int res = 0;
            while (left <= right) {
                lmax = Math.max(lmax, height[left]);
                rmax = Math.max(rmax, height[right]);
                if (lmax < rmax) {
                    res += lmax - height[left];
                    left++;
                } else {
                    res += rmax - height[right];
                    right--;
                }
            }
            return res;

        }

        // 备忘录解法
        public int trap2(int[] height) {

            int n = height.length;
            int lmax[] = new int[n];
            int rmax[] = new int[n];
            lmax[0] = height[0];
            rmax[n-1] = height[n-1];
            for(int i = 1; i < n ; i++) {
                lmax[i] = Math.max(height[i], lmax[i-1]);
            }
            for(int i = n - 2; i >=0; i--) {
                rmax[i] = Math.max(height[i], rmax[i+1]);
            }
            int res = 0;

            for(int i = 0; i < n ; i++) {
                res = res + (Math.min(lmax[i], rmax[i]) - height[i]) * 1;
            }

            return res;
 
        }

        public int trap1(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int lMax = height[0];
            int rMax = height[height.length - 1];
            int res = 0;
            while (left < right) {
                // 更新左边最大值
                lMax = Math.max(lMax, height[left]);
                rMax = Math.max(rMax, height[right]);
                if (lMax < rMax) {
                    // 如果左边小，则用左边的计算，并移动左边
                    res = res + (lMax - height[left]);
                    left ++ ;
                } else {
                    // 如果右边小，则用左边的计算，并移动左边
                    res = res + (rMax - height[right]);
                    right --;
                }
            }
            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        solution.trap(arr);
        // put your test code here

    }
}



/*
// @lcpr case=start
// [0,1,0,2,1,0,1,3,2,1,2,1]\n
// @lcpr case=end

// @lcpr case=start
// [4,2,0,3,2,5]\n
// @lcpr case=end

 */

