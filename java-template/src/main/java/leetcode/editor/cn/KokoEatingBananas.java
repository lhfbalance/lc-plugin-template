/*
 * @lc app=leetcode.cn id=875 lang=java
 * @lcpr version=30403
 *
 * [875] 爱吃香蕉的珂珂
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class KokoEatingBananas {

    // @lc code=start
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {

            int left = 1;
            int right = 1000000000;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                long used = useHour(piles, mid);

                if (used == h) {
                    right = mid - 1;
                } else if (used > h) {
                    left = mid + 1;
                } else if (used < h) {
                    right = mid - 1;
                }
            }

            return left;
            
        }

        // 注意溢出问题，这里要用 long 作为返回值
        public long useHour(int[] piles, int speed) {
            // 注意溢出问题，这里要用 long 作为返回值
            long res = 0;
            for(int i = 0; i< piles.length; i++) {
                res = res + piles[i] / speed;
                res = res + (piles[i] % speed == 0 ? 0 : 1);
            }

            return res;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new KokoEatingBananas().new Solution();
        // put your test code here

        int[] piles = new int[] {1,2,2,1,2};
        System.out.println(solution.minEatingSpeed(piles, 1));

    }
}



/*
// @lcpr case=start
// [3,6,7,11]\n8\n
// @lcpr case=end

// @lcpr case=start
// [30,11,23,4,20]\n5\n
// @lcpr case=end

// @lcpr case=start
// [30,11,23,4,20]\n6\n
// @lcpr case=end

 */

