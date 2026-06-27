/*
 * @lc app=leetcode.cn id=1020 lang=java
 * @lcpr version=30403
 *
 * [1020] 飞地的数量
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class NumberOfEnclaves {

    // @lc code=start
    class Solution {
        // 方向数组，代表一个二维数组中某个坐标的上下左右
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int m;
        int n;
        public int numEnclaves(int[][] grid) {
             m = grid.length;
            n = grid[0].length;
            // 把第0行的岛淹掉
            for(int i = 0; i < n ; i++) {
                if (grid[0][i] == 1) {
                    dfs(grid, 0, i);
                }
            }
            // 把第m-1行的岛淹掉
            for(int i = 0; i < n ; i++) {
                if (grid[m - 1][i] == 1) {
                    dfs(grid, m - 1, i);
                }
            }
            // 把第0列的岛淹掉
            for(int i = 0; i < m ; i++) {
                if (grid[i][0] == 1) {
                    dfs(grid, i, 0);
                }
            }
            // 把第n-1列的岛淹掉
            for(int i = 0; i < m ; i++) {
                if (grid[i][n - 1] == 1) {
                    dfs(grid, i, n - 1);
                }
            }
            int res = 0;
            for (int i = 0; i < m; i++) {
                for(int j = 0; j< n ; j++) {
                    if (grid[i][j] == 1) {
                        res += dfs(grid, i, j);
                    }
                }
            }
            return res;
        }
        // 定义有返回值的 dfs，返回岛屿的面积
        int dfs(int[][] grid, int i, int j) {
            if (i < 0 || i >= m || j < 0 || j >= n) {
                return 0;
            }
            if (grid[i][j] == 0) {
                return 0;
            }

            // tmp是当前坐标，已经被淹，初始化为
            grid[i][j] = 0;
            int tmp = 1;    

            for(int[] dir : dirs) {
                tmp += dfs(grid, i + dir[0], j + dir[1]);
            }
            //后续遍历了
            return tmp;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new NumberOfEnclaves().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]\n
// @lcpr case=end

// @lcpr case=start
// [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]\n
// @lcpr case=end

 */

