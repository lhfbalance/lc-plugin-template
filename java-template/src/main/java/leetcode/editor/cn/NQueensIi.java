/*
 * @lc app=leetcode.cn id=52 lang=java
 * @lcpr version=30403
 *
 * [52] N 皇后 II
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class NQueensIi {

    // @lc code=start
    class Solution {
        public int totalNQueens(int n) {

            List<char[]> path = new LinkedList<>();
            // 初始化路径
            for(int i = 0; i< n; i++) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                path.add(row);
            }
            backtrack(path, 0, n);
            return res;
            
        }

        int res;

        void backtrack(List<char[]> path, int row, int n) {
            if (row == n) {
                // 找到答案
                res++;
                return;
            }

            for(int i = 0; i < n ; i++) {
                if (isValid(path, row, i, n)) {
                    // 选择
                    path.get(row)[i] = 'Q';

                    backtrack(path, row + 1, n);

                    // 撤销选择
                    path.get(row)[i] = '.';
                }
            }
        }

        boolean isValid(List<char[]> path, int row, int col, int n) {
            // 上方
            for(int i = 0; i < row; i++) {
                if (path.get(i)[col] == 'Q') {
                    return false;
                }
            }
            // 左上
            for(int i = row - 1,j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (path.get(i)[j] == 'Q') {
                    return false;
                }
            }
            // 右上
            for(int i = row - 1,j = col + 1; i >= 0 && j < n; i--, j++) {
                if (path.get(i)[j] == 'Q') {
                    return false;
                }
            }
            return true;

        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// 4\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

