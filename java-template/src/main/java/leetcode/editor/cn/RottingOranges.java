/*
 * @lc app=leetcode.cn id=994 lang=java
 * @lcpr version=30403
 *
 * [994] 腐烂的橘子
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RottingOranges {

    // @lc code=start
    class Solution {
        int[][] direct = {{-1,0},{1,0},{0,-1},{0,1}};
        // boolean[][] visited;
        public int orangesRotting(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            
            Queue<int[]> queue = new LinkedList<>();
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n ; j++) {
                    if (grid[i][j] == 2) {
                        queue.offer(new int[]{i, j});
                    }
                }
            }
            int step = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for(int i = 0; i < size; i++) {
                    int[] temp = queue.poll();
                    
                    for(int[] di : direct) {
                        int row = temp[0] + di[0];
                        int col = temp[1] + di[1];
                        if (row >= 0 && row < m && col >=0 && col < n && grid[row][col] == 1) {
                            grid[row][col] = 2;
                            queue.offer(new int[]{row,col});
                        }
                    }
                }
                step++;
            }

            // 检查是否还有好橘子
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n ; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }
            if (step == 0) {
                return 0;
            }

            return step - 1;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new RottingOranges().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [[2,1,1],[1,1,0],[0,1,1]]\n
// @lcpr case=end

// @lcpr case=start
// [[2,1,1],[0,1,1],[1,0,1]]\n
// @lcpr case=end

// @lcpr case=start
// [[0,2]]\n
// @lcpr case=end

 */

