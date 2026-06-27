/*
 * @lc app=leetcode.cn id=79 lang=java
 * @lcpr version=30403
 *
 * [79] 单词搜索
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class WordSearch {

    // @lc code=start
    class Solution {
        boolean found = false;
        public boolean exist(char[][] board, String word) {
            int m = board.length ;
            int n = board[0].length;

            for(int i = 0; i < m ; i++) {
                for(int j = 0; j < n; j++) {
                    dfs(board, i, j, word, 0);
                    if (found) {
                        return true;
                    }
                }
                
            }
            return false;

        }

        void dfs(char[][] board, int row, int col, String word, int index) {
            if (found) {
                return;
            }
            if (index == word.length()) {
                
                found = true;
                
                return;
            }
            int m = board.length ;
            int n = board[0].length;
            if (row < 0 || row >= m || col < 0 || col >= n) {
                return;
            } 
            if (board[row][col] != word.charAt(index)) {
                return;
            }
            
            board[row][col] = (char)(-board[row][col]);
            dfs(board, row+1, col, word, index+1);
            dfs(board, row-1, col, word, index+1);
            dfs(board, row, col-1, word, index+1);
            dfs(board, row, col+1, word, index+1);
            board[row][col] = (char)(-board[row][col]);

        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"\n
// @lcpr case=end

// @lcpr case=start
// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"SEE"\n
// @lcpr case=end

// @lcpr case=start
// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCB"\n
// @lcpr case=end

 */

