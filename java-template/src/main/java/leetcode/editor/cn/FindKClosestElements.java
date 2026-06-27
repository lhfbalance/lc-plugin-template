/*
 * @lc app=leetcode.cn id=658 lang=java
 * @lcpr version=30403
 *
 * [658] 找到 K 个最接近的元素
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class FindKClosestElements {

    // @lc code=start
    class Solution {

        public int findLeftbound(int[] arr, int x) {
            int left = 0;
            int right = arr.length - 1;
            while (left <= right) {
                int mid = left + (right - right)/2;
                if (arr[mid] > x) {
                    right = mid - 1;
                } else if (arr[mid] < x) {
                    left = mid + 1;
                } else if (arr[mid] == x) {
                    right = mid - 1;
                }
            }
            return left;
        }

        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            // 先找左边界，第一个等于 x 的，或大于 x 的最小索引
            
            int p = findLeftbound(arr, x);

            int left = p - 1;
            int right = p;
            
            List<Integer> res = new LinkedList<>();
            // 开区间(left,right)
            while (right - left - 1 < k) {
                if (left == -1) {
                    right++;
                } else if(right == arr.length) {
                    left --;
                } else if(Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                    right ++;
                } else {
                    left --;
                }
            }
            for(int i = left + 1; i < right; i++) {
                res.add(arr[i]);
            }
            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new FindKClosestElements().new Solution();
        int[] arr = {1,2,3,4,5};
        System.out.println(solution.findClosestElements(arr, 4, 3));
        // put your test code here

    }
}



/*
// @lcpr case=start
// [1,2,3,4,5]\n4\n3\n
// @lcpr case=end

// @lcpr case=start
// [1,1,2,3,4,5]\n4\n-1\n
// @lcpr case=end

 */

