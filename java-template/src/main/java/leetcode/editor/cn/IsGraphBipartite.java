/*
 * @lc app=leetcode.cn id=785 lang=java
 * @lcpr version=30403
 *
 * [785] 判断二分图
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class IsGraphBipartite {

    // @lc code=start
    class Solution {
        boolean[] visited;
        boolean[] color;
        boolean ok = true;
        public boolean isBipartite(int[][] graph) {
            visited = new boolean[graph.length];
            color = new boolean[graph.length];

            for(int i = 0; i < graph.length; i++) {
                // 非连通图，需要遍历所有的连通分量(连通子图)
                if (!visited[i]) {
                    bfs(graph, i);
                }
            }
            return ok;
        }

        void bfs(int[][] graph, int src) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(src);
            // visited在这里赋值更高效，避免入队出队
            // visited[src] = true;
            // 加上 ok 这个条件，可以避免同一个连通分量无用的遍历
            while (!queue.isEmpty() && ok) {
                int cur = queue.poll();
                // 开始扩散
                for(int to : graph[cur]) {
                    if (!visited[to]) {
                        color[to] = !color[cur];
                        visited[to] = true;
                        queue.offer(to);
                    } else {
                        if (color[cur] == color[to]) {
                            ok = false;
                            return;
                        }
                    }
                }
            }
        }

        void travese(int[][] graph, int src) {
            if (!ok) {
                // 已经确定不是二分图，提前结束
                return;
            }
            visited[src] = true;

            for(int to : graph[src]) {
                if (!visited[to]) {
                    // 如果没有访问过，相邻节点染色成不一样的颜色
                    color[to] = !color[src];
                    // 递归染色
                    travese(graph, to);
                } else {
                    // 如果有访问过，检查颜色是否一样
                    if (color[src] == color[to]) {
                        ok = false;
                        return;
                    }
                }
            }
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new IsGraphBipartite().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// [[1,2,3],[0,2],[0,1,3],[0,2]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,3],[0,2],[1,3],[0,2]]\n
// @lcpr case=end

 */

