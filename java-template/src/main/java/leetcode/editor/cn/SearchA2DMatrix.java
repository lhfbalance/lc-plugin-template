/*
 * @lc app=leetcode.cn id=74 lang=java
 * @lcpr version=30403
 *
 * [74] 搜索二维矩阵
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SearchA2DMatrix {

    // @lc code=start
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;


            int left = 0;
            int right = m * n - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int midValue = get(matrix, mid);
                if (midValue == target) {
                    return true;
                }
                if (midValue > target) {
                    right = mid - 1;
                }
                if (midValue < target) {
                    left = mid + 1;
                }
            }
            return false;
            
        }

        int get(int[][] arr, int index) {
            int row = index / arr[0].length;
            int col = index % arr[0].length;

            return arr[row][col];
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new SearchA2DMatrix().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [[1,3,5,7],[10,11,16,20],[23,30,34,60]]\n3\n
// @lcpr case=end

// @lcpr case=start
// [[1,3,5,7],[10,11,16,20],[23,30,34,60]]\n13\n
// @lcpr case=end

 */

