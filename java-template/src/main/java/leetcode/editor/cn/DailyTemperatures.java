/*
 * @lc app=leetcode.cn id=739 lang=java
 * @lcpr version=30403
 *
 * [739] 每日温度
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class DailyTemperatures {

    // @lc code=start
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            int[] res = new int[n];
            Stack<Integer> stack = new Stack<>();

            for(int i = n - 1; i >=0; i--) {
                // 这要用大于等于，等于也不算升高，要 pop 出来
                while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    res[i] = stack.peek() - i ;
                } else {
                    // 说明后续没有比当前温度高的天数
                    res[i] = 0;
                }
                stack.push(i);
            }
            return res;
            
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [73,74,75,71,69,72,76,73]\n
// @lcpr case=end

// @lcpr case=start
// [30,40,50,60]\n
// @lcpr case=end

// @lcpr case=start
// [30,60,90]\n
// @lcpr case=end

 */

