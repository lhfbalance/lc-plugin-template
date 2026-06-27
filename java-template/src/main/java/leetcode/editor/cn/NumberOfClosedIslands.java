/*
 * @lc app=leetcode.cn id=1254 lang=java
 * @lcpr version=30403
 *
 * [1254] 统计封闭岛屿的数目
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class NumberOfClosedIslands {

    // @lc code=start
    class Solution {
        // 方向数组，代表一个二维数组中某个坐标的上下左右
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int m;
        int n;
        public int closedIsland(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            // 把第0行的岛淹掉
            for(int i = 0; i < n ; i++) {
                if (grid[0][i] == 0) {
                    dfs(grid, 0, i);
                }
            }
            // 把第m-1行的岛淹掉
            for(int i = 0; i < n ; i++) {
                if (grid[m - 1][i] == 0) {
                    dfs(grid, m - 1, i);
                }
            }
            // 把第0列的岛淹掉
            for(int i = 0; i < m ; i++) {
                if (grid[i][0] == 0) {
                    dfs(grid, i, 0);
                }
            }
            // 把第n-1列的岛淹掉
            for(int i = 0; i < m ; i++) {
                if (grid[i][n - 1] == 0) {
                    dfs(grid, i, n - 1);
                }
            }
            int res = 0;
            for (int i = 0; i < m; i++) {
                for(int j = 0; j< n ; j++) {
                    if (grid[i][j] == 0) {
                        res++;
                        dfs(grid, i, j);
                    }
                }
            }
            return res;
            
        }

        void dfs(int[][] grid, int i ,int j) {
            if (i < 0 || i>= m || j < 0 || j>=n) {
                // 越界，直接返回
                return;
            }
            if (grid[i][j] == 1) {
                // 已经是海水，直接返回
                return;
            }
            if (grid[i][j] == 0) {
                grid[i][j] = 1;
            }

            for(int[] dir : dirs) {
                dfs(grid, i + dir[0], j + dir[1]);
            }

        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new NumberOfClosedIslands().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]\n
// @lcpr case=end

// @lcpr case=start
// [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,1,1,1,1,1,1],[1,0,0,0,0,0,1],[1,0,1,1,1,0,1],[1,0,1,0,1,0,1],[1,0,1,1,1,0,1],[1,0,0,0,0,0,1],[1,1,1,1,1,1,1]]\n
// @lcpr case=end

 */

