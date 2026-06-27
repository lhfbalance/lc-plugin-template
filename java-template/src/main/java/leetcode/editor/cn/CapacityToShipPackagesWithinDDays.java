/*
 * @lc app=leetcode.cn id=1011 lang=java
 * @lcpr version=30403
 *
 * [1011] 在 D 天内送达包裹的能力
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class CapacityToShipPackagesWithinDDays {

    // @lc code=start
    class Solution {
        public int shipWithinDays(int[] weights, int days) {

            
            int left = 0;
            int right = 0;

            for(int i = 0; i< weights.length;i++) {
                // left应该是最重的那个
                left = Math.max(left, weights[i]);
                // right应该是所有货物的总重量，也就是一次性拉完
                right = right + weights[i];
            }

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int useDays = useDays(weights, mid);
                if (useDays == days) {
                    right = mid - 1;
                } else if (useDays < days) {
                    right = mid - 1;
                } else if (useDays > days) {
                    left = mid + 1;
                }
            }

            return left;
            
        }

        public int useDays(int[] weights, int capacity) {
            int res = 0;
            int tmp = 0;
            int i = 0;
            while (i < weights.length) {
                if (tmp + weights[i] <= capacity) {
                    tmp = tmp + weights[i];
                    i++;
                } else {
                    // 即将达到容量，
                    tmp = 0;
                    res = res + 1;
                }
                
            }
            if (tmp !=0) {
                res++;
            }


            return res;

        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new CapacityToShipPackagesWithinDDays().new Solution();
        // put your test code here
        int[] weights = new int[] {3,2,2,4,1,4};
        System.out.println(solution.useDays(weights, 2));

    }
}



/*
// @lcpr case=start
// [1,2,3,4,5,6,7,8,9,10]\n5\n
// @lcpr case=end

// @lcpr case=start
// [3,2,2,4,1,4]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,1,1]\n4\n
// @lcpr case=end

 */

