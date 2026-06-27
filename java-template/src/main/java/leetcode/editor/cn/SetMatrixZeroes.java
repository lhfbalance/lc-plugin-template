/*
 * @lc app=leetcode.cn id=73 lang=java
 * @lcpr version=30403
 *
 * [73] 矩阵置零
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SetMatrixZeroes {

    // @lc code=start
    class Solution {
        public void setZeroes(int[][] matrix) {
            boolean firstRowIsZero = false;
            boolean firstColIsZero = false;
            // 看第一行是否包含 0；
            for(int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i] == 0) {
                    firstRowIsZero = true;
                }
            }
            // 看第一列是否包含 0；
            for(int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    firstColIsZero = true;
                }
            }

            for(int i = 1; i < matrix.length; i++) {
                for(int j = 1; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            for(int i = 1; i < matrix.length; i++) {
                for(int j = 1; j < matrix[0].length; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;  
                    }
                }
            }
            if (firstRowIsZero) {
               for(int i = 0; i < matrix[0].length; i++) {
                    // 第一行均置零
                    matrix[0][i] = 0;
                } 
            }
            
            if (firstColIsZero) {
                for(int i = 0; i < matrix.length; i++) {
                    // 第一列均置零
                    matrix[i][0] = 0;
                }                
            }

            
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new SetMatrixZeroes().new Solution();
        int[][] arr = {{1,1,1},{1,0,1},{1,1,1}};
        solution.setZeroes(arr);
        // put your test code here

    }
}



/*
// @lcpr case=start
// [[1,1,1],[1,0,1],[1,1,1]]\n
// @lcpr case=end

// @lcpr case=start
// [[0,1,2,0],[3,4,5,2],[1,3,1,5]]\n
// @lcpr case=end

 */

