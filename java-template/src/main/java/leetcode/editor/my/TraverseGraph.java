package leetcode.editor.my;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TraverseGraph {

    void traverse(Graph graph, int s,  boolean[] visited) {
        if (s < 0 || s >= graph.size()) {
            // base case 什么情况下会出现呢???
            return;
        }
        if (visited[s]) {
            return;
        }
        // 前序位置
        visited[s] = true;

        for(Edge edge : graph.neighbors(s)) {
            traverse(graph, edge.to, visited);
        }
        // 后序位置
    }

    void traverseEdge(Graph graph, int s,  boolean[][] visited) {
        if (s < 0 || s >= graph.size()) {
            // base case 什么情况下会出现呢???
            return;
        }

        for(Edge edge : graph.neighbors(s)) {
            if (visited[s][edge.to]) {
                continue;
            }
            // 记录已经遍历过的边
            visited[s][edge.to] = true;
            traverseEdge(graph, edge.to, visited);
        }
        // 后序位置
    }

    Graph graph;
    // onPath 和 path 记录当前递归路径上的节点
    boolean[] onPath = new boolean[graph.size()];
    List<Integer> path = new LinkedList<>();
    void traversPath(Graph graph, int src, int dest) { 
        // base case
        if (src < 0 || src > graph.size()) {
            return;
        }

        // 
        if (onPath[src]) {
            // 当前节点已经在路径中了，避免成环，直接返回
            return;
        }

        if (src == dest) {
            // 找到目标节点
            System.out.println("find path:" + "->" +  path + "->" + dest);
            return;
        }
        // 前序位置
        onPath[src] = true;
        path.addLast(src);
        for(Edge edge : graph.neighbors(src)) {
            traversPath(graph, dest, edge.to);
        }
        // 后续位置
        path.removeLast();
        onPath[src] = false;
    }

    void bfs(Graph graph, int s) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        while (!queue.isEmpty()) {
            // int size = queue.size();
            // for(int i = 0; i < size; i++) {
                int cur = queue.poll(); 
                for(Edge edge : graph.neighbors(cur)) {
                    if (visited[edge.to]) {
                        continue;
                    }
                    visited[cur] = true;
                    queue.offer(edge.to);
                }  
            // }
            
        }
    }

    void bfsRecordLevel(Graph graph, int s) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int cur = queue.poll(); 
                System.out.println("visit " + cur + " at step " + step);
                for(Edge edge : graph.neighbors(cur)) {
                    if (visited[edge.to]) {
                        continue;
                    }
                    visited[cur] = true;
                    queue.offer(edge.to);
                }  
            }
            step++;
        }
    }

    class State {
        int node;
        int step;

        State(int node, int step) {
            this.node = node;
            this.step = step;
        }
    }
    void bfsRecordLevel2(Graph graph, int s) {
        boolean[] visited = new boolean[graph.size()];
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(s, 0));
        while (!queue.isEmpty()) {
            State cur = queue.poll();
            System.out.println("visit " + cur.node + " with step " + cur.step);
            for(Edge edge : graph.neighbors(cur.node)) {
                if (visited[edge.to]) {
                    continue;
                }
                visited[edge.to] = true;
                queue.offer(new State(edge.to, cur.step + 1));
            }
        }

    }

}
