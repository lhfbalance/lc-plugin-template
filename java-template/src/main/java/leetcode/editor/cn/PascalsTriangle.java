/*
 * @lc app=leetcode.cn id=118 lang=java
 * @lcpr version=30403
 *
 * [118] 杨辉三角
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class PascalsTriangle {

    // @lc code=start
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new LinkedList<>();
            List<Integer> pre = new LinkedList<>();
            pre.add(1);
            res.add(pre);
            // 第一行是 base case， 第二行开始迭代
            for(int i = 2; i <= numRows; i++) {
                List<Integer> cur = new LinkedList<>();
                for(int j = 0; j < i; j++) {
                    if (j == 0 || j == i - 1) {
                        cur.add(1);
                    } else {
                        cur.add(pre.get(j - 1) + pre.get(j));
                    }
                }
                res.add(cur);
                pre = cur;
            }
            return res;
            
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// 5\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

