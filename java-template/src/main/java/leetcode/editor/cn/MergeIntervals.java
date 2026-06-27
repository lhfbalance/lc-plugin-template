/*
 * @lc app=leetcode.cn id=56 lang=java
 * @lcpr version=30403
 *
 * [56] 合并区间
 */

package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.*;
import leetcode.editor.common.*;

public class MergeIntervals {

    // @lc code=start
    class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> res = new LinkedList<>();
            if (intervals.length <= 1) {
                return intervals;
            }
            // 按起始位置排序
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            
            int index=0;
            int start = intervals[0][0];
            int end = intervals[0][1];
            int[] interval = {start, end};
            // 加入结果
            res.add(interval);
            for(int i = index + 1; i < intervals.length; i++) {
                if (intervals[i][0] <= interval[1]) {
                    // 有交集
                    interval[1] = Math.max(interval[1], intervals[i][1]);
                    
                } else {
                    // 无交集
                    // 更新新的起始和结束点，作为下一个待加入的区间
                    start = intervals[i][0];
                    end = intervals[i][1];
                    interval = new int[]{start, end};
                    // 加入结果
                    res.add(interval);
                }
            }
            
            // int[] interval = {start, end};
            // // 加入结果
            // res.add(interval);
            return res.toArray(new int[0][0]);
            
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [[1,3],[2,6],[8,10],[15,18]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,4],[4,5]]\n
// @lcpr case=end

// @lcpr case=start
// [[4,7],[1,4]]\n
// @lcpr case=end

 */

