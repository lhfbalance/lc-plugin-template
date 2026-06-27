/*
 * @lc app=leetcode.cn id=1584 lang=java
 * @lcpr version=30403
 *
 * [1584] 连接所有点的最小费用
 */

package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MinCostToConnectAllPoints {

    // @lc code=start
    class Solution {
        public int minCostConnectPoints(int[][] points) {
            // 生成所有边及其权重
            List<int[]> edges = new LinkedList<>();
            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    int[] edge = new int[3];
                    edge[0] = i;
                    edge[1] = j;
                    edge[2] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                    edges.add(edge);
                }
            }
            MyUF myUF = new MyUF(points.length);
            // 按权重排序
            Collections.sort(edges, (e1, e2) -> e1[2] - e2[2]);

            int fee = 0;
            for(int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];
                if (myUF.connected(from, to)) {
                    // 成环了，不连接
                    continue;
                }
                myUF.union(from, to);
                fee += weight;
            }
            
            return fee;
        }
    }
    class MyUF {

        // 连通分量的个数
        private int count;

        // 父节点数组，每个连通分量有且只有一个父节点
        private int[] parent;

        // 各连通分量里节点数量
        private int[] size;

        public MyUF(int nums) {
            parent = new int[nums];
            size = new int[nums];
            count = nums;
            for(int i=0; i<nums; i++) {
                // 初始化所有节点的根节点是自己
                parent[i] = i;
                // 初始化每个节点都是一个连通分量，节点数量是 1
                size[i] = 1;
            }
        }

        // 路径压缩的核心体系，每执行一次这个方法，
        // 会把 x 到根节点之间的所有节点直接接到根节点下面
        private int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
                x = parent[x];
            }
            return x;
        }

        // 将节点 p，q 连接
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) {
                // 已经是连通的了
                return;
            }

            if(rootP > rootQ) {
                // 合并两个连通分量，即两个根节点，到 rootQ 上
                parent[rootQ] = rootP;
                // 合并两个连通分量的节点数量，到 rootQ 上
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }

            count --;
        }

        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            return rootP == rootQ;
        }

        // 返回连通分量的个数
        public int count() {
            return count;
        }

        // 返回节点 x 所在连通分量的节点个数
        public int size(int x) {
            int rootX = find(x);
            return size(rootX);
        }

    }

    // @lc code=end

    public static void main(String[] args) {
        Solution solution = new MinCostToConnectAllPoints().new Solution();
        int[][] array = {{3,12},{-2,5},{-4,1}};
        solution.minCostConnectPoints(array);
        // put your test code here

    }
}

/*
 * // @lcpr case=start
 * // [[0,0],[2,2],[3,10],[5,2],[7,0]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[3,12],[-2,5],[-4,1]]\n
 * // @lcpr case=end
 * 
 */
