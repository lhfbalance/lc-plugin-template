/*
 * @lc app=leetcode.cn id=240 lang=java
 * @lcpr version=30403
 *
 * [240] 搜索二维矩阵 II
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SearchA2DMatrixIi {

    // @lc code=start
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;

            int i = 0;
            int j = n - 1;
            // 右上角开始遍历，往左走一步是减小值，往下走一步是增大值
            while (i < m && j >=0) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] > target) {
                    j--;
                    
                } else if (matrix[i][j] < target) {
                    i++;
                    
                }
            }
            return false;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new SearchA2DMatrixIi().new Solution();
        int[][] arr = {{1}};
        solution.searchMatrix(arr, 0);
        // put your test code here

    }
}



/*
// @lcpr case=start
// [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]\n5\n
// @lcpr case=end

// @lcpr case=start
// [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]\n20\n
// @lcpr case=end

 */

