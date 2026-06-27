/*
 * @lc app=leetcode.cn id=200 lang=java
 * @lcpr version=30403
 *
 * [200] 岛屿数量
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class NumberOfIslands {

    // @lc code=start
    class Solution {
        // 方向数组，代表一个二维数组中某个坐标的上下左右
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int m;
        int n;
        public int numIslands(char[][] grid) {
            m = grid.length;
            n = grid[0].length;
            // visited = new boolean[m][n];
            int res = 0;
            for(int i = 0; i < m; i ++) {
                for(int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        res ++ ;
                        dfs(grid, i, j);
                    }
                }
            }
            return res;
        }

        void dfs(char[][] grid, int i, int j){
            if (i < 0 || i >=m || j <0 || j>=n) {
                // 越界返回
                return;
            }
            if (grid[i][j] == '0') {
                // 已经是海水
                return;
            }
            if (grid[i][j] == '1') {
                // 用海水淹掉，同时也相当于标记了其已经 visited
                grid[i][j] = '0';
            }
            for(int[] dir : dirs) {
                dfs(grid, i + dir[0], j + dir[1]);
            }
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]\n
// @lcpr case=end

// @lcpr case=start
// [["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]\n
// @lcpr case=end

 */

