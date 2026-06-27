/*
 * @lc app=leetcode.cn id=1905 lang=java
 * @lcpr version=30403
 *
 * [1905] 统计子岛屿
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class CountSubIslands {

    // @lc code=start
    class Solution {
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int m;
        int n;
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            m = grid2.length;
            n = grid2[0].length;
            for (int i = 0; i < m; i++) {
                for(int j = 0; j< n ; j++) {
                    // 在 2 中是陆地，在 1 中是海水，那么这个陆地所在的岛屿一定不可能是子岛屿，淹掉
                    if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                        // 淹掉不可能是子岛屿的岛屿
                        dfs(grid2, i, j);
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < m; i++) {
                for(int j = 0; j< n ; j++) {
                    if (grid2[i][j] == 1) {
                        // 搜索子岛屿；
                        res++;
                        dfs(grid2, i, j);
                    }
                }
            }
            return res;
        }
        void dfs(int[][] grid, int i, int j) {
            if (i < 0 || i >= m || j < 0 || j >= n) {
                return;
            }
            if (grid[i][j] == 0) {
                // 是海水直接返回
                return;
            }
            // 是陆地的直接淹掉
            grid[i][j] = 0;
            for(int[] dir : dirs) {
                dfs(grid, i + dir[0], j + dir[1]);
            }
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new CountSubIslands().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]]\n[[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]]\n[[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]\n
// @lcpr case=end

 */

