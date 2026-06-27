/*
 * @lc app=leetcode.cn id=886 lang=java
 * @lcpr version=30403
 *
 * [886] 可能的二分法
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class PossibleBipartition {

    // @lc code=start
    class Solution {
        List<Integer>[] graph;
        boolean[] visied;
        boolean[] color;
        boolean res = true;
        @SuppressWarnings("unchecked")
        public boolean possibleBipartition(int n, int[][] dislikes) {
            graph = new LinkedList[n + 1];
            visied = new boolean[n + 1];
            color = new boolean[n + 1];

            // 以 dislike 为边集合构建图
            buildGraph(graph, dislikes);

            // 遍历图，确定所有的子图都是二分图
            for(int i = 1; i < graph.length; i++) {
                if (!visied[i]) {
                    travese(graph, i);
                }
                
            }

            return res;

        }

        void travese(List<Integer>[] graph, int start) {
            if (!res) {
                return;   
            }
            visied[start] = true;
            for(Integer neibor : graph[start]) {
                if (!visied[neibor]) {
                    color[neibor] = !color[start];
                    travese(graph, neibor);
                } else {
                    if (color[start] == color[neibor]) {
                        res = false;
                        return;
                    }
                }
            }

        }

        void buildGraph(List<Integer>[] graph, int[][] edges) {
            for(int i = 1; i < graph.length ; i++) {
                graph[i] = new LinkedList<>();
            }
            for(int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                graph[from].add(to);
                graph[to].add(from);
            }
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new PossibleBipartition().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// 4\n[[1,2],[1,3],[2,4]]\n
// @lcpr case=end

// @lcpr case=start
// 3\n[[1,2],[1,3],[2,3]]\n
// @lcpr case=end

 */

