/*
 * @lc app=leetcode.cn id=84 lang=java
 * @lcpr version=30403
 *
 * [84] 柱状图中最大的矩形
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class LargestRectangleInHistogram {

    // @lc code=start
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] h = new int[n + 2];
            for(int i = 0; i < n ; i ++) {
                h[i + 1] = heights[i];
            }
            Stack<Integer> stack = new Stack<>();
            int res =0;
            for(int i = 0; i < h.length ; i++) {
                while (!stack.isEmpty() && h[stack.peek()] > h[i]) {
                    // 被 pop 出来的就是要计算的矩形高度
                    int height = h[stack.pop()];
                    // 新的栈顶元素就是上一个比 height 小的索引
                    int j = stack.peek();
                    // i是下一个比 height 小的索引
                    res = Math.max(res, (i - j - 1) * height);
                }
                stack.push(i);
            }
            return res;   
        }

    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [2,1,5,6,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [2,4]\n
// @lcpr case=end

 */

