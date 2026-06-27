/*
 * @lc app=leetcode.cn id=96 lang=java
 * @lcpr version=30403
 *
 * [96] 不同的二叉搜索树
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class UniqueBinarySearchTrees {

    // @lc code=start
    class Solution {
        public int numTrees(int n) {
            memo2 = new int[n+1];
            return count(1, n);
        }
        int[][] memo;
        int[] memo2;
        private int count(int lo, int hi) {

            if (hi - lo <= 0) {
                return 1;
            }
            // if (hi - lo == 1) {
            //     return 1;
            // }
            // 查询备忘录
            if (memo2[hi - lo] > 0) {
                return memo2[hi - lo];
            }
            
            int temp = 0;
            for(int i = lo; i <= hi ; i++) {
                // 选择不同根节点后，二叉搜索数的种类等于左子树的种类*右子树的种类，累加
                int leftCount = count(lo, i - 1);
                int rightCount = count(i + 1, hi);
                temp = temp +  leftCount * rightCount; 
            }
            // 记录备忘录
            memo2[hi - lo] = temp;

            return temp;

        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// 3\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

