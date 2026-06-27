/*
 * @lc app=leetcode.cn id=566 lang=java
 * @lcpr version=30403
 *
 * [566] 重塑矩阵
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ReshapeTheMatrix {

    // @lc code=start
    class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {

            int m = mat.length;
            int n = mat[0].length;
            if (m * n != r * c) {
                return mat;
            } else {
                int[][] res = new int[r][c];
                for(int i = 0; i < m * n; i++) {
                    set(res, i, get(mat, i));
                }
                return res;
            }
            
        }

        // 用一维数组的 index 访问二维数组的数据
        private int get(int[][] arr, int index) {
            int row = index / arr[0].length;
            int col = index % arr[0].length;
            return arr[row][col];
        }

        private void set(int[][] arr, int index, int value) {
            int row = index / arr[0].length;
            int col = index % arr[0].length;
            arr[row][col] = value;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new ReshapeTheMatrix().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [[1,2],[3,4]]\n1\n4\n
// @lcpr case=end

// @lcpr case=start
// [[1,2],[3,4]]\n2\n4\n
// @lcpr case=end

 */

