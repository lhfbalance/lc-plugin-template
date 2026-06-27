/*
 * @lc app=leetcode.cn id=169 lang=java
 * @lcpr version=30403
 *
 * [169] 多数元素
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MajorityElement {

    // @lc code=start
    class Solution {
        public int majorityElement(int[] nums) {

            int target = 0;
            int count = 0;
            for(int num: nums) {
                if (count == 0) {
                    // 加上当前 num 就是 target
                    target = num;
                    count ++ ;
                } else if (num == target) {
                    count ++;
                } else  {
                    count --;
                }
            }
            return target;

            // Map<Integer, Integer> map = new HashMap<>();
            // for(int num : nums) {
            //     int count;
            //     if (map.containsKey(num)) {
            //         count = map.get(num) + 1;
                    
            //         map.put(num, count);
                    
            //     } else {
            //         count = 1;
            //         map.put(num, 1);
            //     }
            //     if (count > nums.length / 2) {
            //             return num;
            //     }
            // }
            // return Integer.MIN_VALUE;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
        // put your test code here

    }
}

/*
 * // @lcpr case=start
 * // [3,2,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [2,2,1,1,1,2,2]\n
 * // @lcpr case=end
 * 
 */
