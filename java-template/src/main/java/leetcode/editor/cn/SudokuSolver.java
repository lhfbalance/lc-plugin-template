/*
 * @lc app=leetcode.cn id=37 lang=java
 * @lcpr version=30403
 *
 * [37] 解数独
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class SudokuSolver {

    // @lc code=start
    class Solution {
        public void solveSudoku(char[][] board) {
            backtrack(board, 0);
        }
        int length = 9*9;
        boolean found;

        void backtrack(char[][] board, int start) {
            if (found) {
                // 已经找到一个可行解，立即结束
                return;
            }
            if (start == length) {
                // base case
                // 已到达最后一个格子
                found = true;
                return;
            }
            int row = start / 9;
            int col = start % 9;
            if (board[row][col] != '.') {
                // 已经提前放过元素了，不需要穷举，直接穷举下一个即可
                backtrack(board, start + 1);
                return;
            }
            for(char i = '1' ; i <= '9' ; i ++) {
                
                // 判断是否可以放
                if(!isValid(board, row, col, i)) {
                    // 不符合数独的规则，剪枝
                    continue;
                }
                // 选择
                board[row][col] = i;

                backtrack(board, start + 1);
                if(found) {
                    // 找到答案后，立刻结束递归,
                    return;
                }
                // 撤销选择
                board[row][col] = '.';

            }
        }

        boolean isValid(char[][] board, int row, int col, char value) {
            
            for(int i = 0; i < 9; i++) {
                // 行规则
                if (board[row][i] == value) {
                    return false;
                }
                // 列规则
                if (board[i][col] == value) {
                    return false;
                }
                // 3*3小方格规则, 行取除，列取余数
                if (board[(row/3) * 3 + i/3][(col/3) * 3 + i%3] == value) {
                    return false;
                }
            }
            return true;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new SudokuSolver().new Solution();
        char[][] chars = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        solution.solveSudoku(chars);
        // put your test code here

    }
}



/*
// @lcpr case=start
// [['5',"3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]\n
// @lcpr case=end

 */

