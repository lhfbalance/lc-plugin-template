/*
 * @lc app=leetcode.cn id=207 lang=java
 * @lcpr version=30403
 *
 * [207] 课程表
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class CourseSchedule {

    // @lc code=start
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
            // 每个节点的入度
            int[] indegree = new int[numCourses];
            for(int[] edge : prerequisites) {
                //方向 edge[1] >  dege[0]
                int to = edge[0];
                indegree[to]++;
            }
            Queue<Integer> queue = new LinkedList<>();
            // 遍历所有节点的入度，优先把入度为 0 的加入到队列中，即没有依赖的节点
            for(int i =0 ; i< numCourses; i++) {
                if (indegree[i] == 0) {
                    // 所有入度为 0 的先加入队列
                    queue.add(i);
                }
            }
            // 遍历节点的数量，初始为 0；
            int count = 0;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                // 遍历的节点数量加 1
                count ++;
                for(int next : graph[cur]) {
                    // 当前节点指向的下一个节点的入度减 1
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        // 下一个节点的入度为 0 则可以加入到队列中
                        queue.offer(next);
                    }
                }
            }
            // 如果遍历的节点数量和节点总数量一致，则说明没有环
            return count == numCourses;
        }

        boolean[] onPath;
        boolean[] visited;
        boolean hasCycle = false;
        
        public boolean canFinishWithDFS(int numCourses, int[][] prerequisites) {

            List<Integer>[] graph = buildGraph(numCourses, prerequisites);
            // 初始化 onPath 数组和 visited 数组
            onPath = new boolean[numCourses];
            visited = new boolean[numCourses];

            for(int i = 0; i < numCourses; i++) {
                traverse(graph, i); 
            }
            return !hasCycle;
            
        }

        

        void traverse(List<Integer>[] graph, int src) {
            // 已经成环，直接返回
            if (hasCycle) {
                return;
            }
            
            // 该节点已经在路径上了，说明成环
            if (onPath[src]) {
                hasCycle = true;
                return;
            }

            // 剪枝一定要放在这里，不能放在检测是否成环的前面
            // 放在检测是否成环的前面，还不确定有没有成环，是不能随意剪去的，比如[1,2],[2,3],[3,4],[4,2]，遍历顺序是 1>2>3>4>2,如果提前剪枝，就判断不出来有环了
            // 已经访问过且无环，直接返回，这里其实隐含了一个条件就是以 src 为起点的子图是无环的，否则不会走到这里在上面就返回了
            if (visited[src]) {
                return;
            }
            visited[src] = true;
            // 前序位置加入 onPath
            onPath[src] = true;
            for(int to : graph[src]) {
                traverse(graph, to);
            }
            // 后序位置取消 onPath
            onPath[src] = false;
        }

        @SuppressWarnings("unchecked")
        List<Integer>[] buildGraph(int size, int[][] prerequisites) {
            List<Integer>[] graph = new LinkedList[size];
            for(int i = 0; i< graph.length; i++) {
                graph[i] = new LinkedList<>();
            }
            for(int[] edge : prerequisites) {
                int from = edge[1];
                int to = edge[0];
                graph[from].add(to);
            }
            return graph;
        }
    }
    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();
        // put your test code here

    }
}



/*
// @lcpr case=start
// 2\n[[1,0]]\n
// @lcpr case=end

// @lcpr case=start
// 2\n[[1,0],[0,1]]\n
// @lcpr case=end

 */

