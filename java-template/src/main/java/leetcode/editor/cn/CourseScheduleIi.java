/*
 * @lc app=leetcode.cn id=210 lang=java
 * @lcpr version=30403
 *
 * [210] 课程表 II
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class CourseScheduleIi {

    // @lc code=start
    class Solution {
        boolean[] visited;
        boolean[] onPath;
        boolean hasCycle;
        List<Integer> postOrder = new LinkedList<>();
        public int[] findOrder(int numCourses, int[][] prerequisites) {

            List<Integer>[] graph = build(numCourses, prerequisites);
            visited = new boolean[numCourses];
            onPath = new boolean[numCourses];

            for(int i = 0; i < graph.length; i++) {
                if (!visited[i]) {
                    traverse(graph, i);
                }
            }
            if (hasCycle) {
                return new int[0];
            }

            // 你想后续遍历的结果，就是拓扑排序的结果
            // Collections.reverse(postOrder);
            int[] res = new int[postOrder.size()];
            for(int i = postOrder.size() - 1,j = 0; i >=0; i--,j++) {
                res[j] = postOrder.get(i);
            }
            return res;
        }

        void traverse(List<Integer>[] graph, int src) {
            if (hasCycle) {
                // 已经有环了，直接返回
                return;
            }
            // 判断是否有环
            if (onPath[src]) {
                hasCycle = true;
                return;
            }
            if (visited[src]) {
                // 已经遍历过了，剪枝
                return;
            }
            visited[src] = true;

            onPath[src] = true;
            for(int next : graph[src]) {
                traverse(graph, next);
            }
            onPath[src] = false;
            postOrder.add(src);
        }

        // 构建图--邻接表
        @SuppressWarnings("unchecked")
        List<Integer>[] build(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = new LinkedList[numCourses];
            for(int i = 0; i < numCourses; i++) {
                graph[i] = new LinkedList<>();
            }
            for(int i = 0; i < prerequisites.length; i++) {
                int from = prerequisites[i][1];
                int to = prerequisites[i][0];
                graph[from].add(to);
            }
            return graph;
        }

    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new CourseScheduleIi().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// 2\n[[1,0]]\n
// @lcpr case=end

// @lcpr case=start
// 4\n[[1,0],[2,0],[3,1],[3,2]]\n
// @lcpr case=end

// @lcpr case=start
// 1\n[]\n
// @lcpr case=end

 */

