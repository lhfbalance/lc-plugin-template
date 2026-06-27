package leetcode.editor.my;

import java.util.ArrayList;
import java.util.List;

public class WeightGraph implements Graph {

    List<Edge>[] graph;

    @SuppressWarnings("unchecked")
    public WeightGraph(int n) {
        graph = new List[n];
        for(int i = 0; i < n ; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    //
    @Override
    public void addEdge(int from, int to, int weigth) {
        graph[from].add(new Edge(to, weigth));
    }

    // 
    @Override
    public void removeEdge(int from, int to) {
        List<Edge> edges = graph[from];
        for(int i = 0; i < edges.size(); i++) {
            if (edges.get(i).to == to) {
                edges.remove(i);
                break;
            }
        }
    }

    @Override
    public boolean hasEdge(int from, int to) {
        List<Edge> edges = graph[from];
        for(int i = 0; i < edges.size(); i++) {
            if (edges.get(i).to == to) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int weigth(int from, int to) {
        List<Edge> edges = graph[from];
        for(int i = 0; i < edges.size(); i++) {
            if (edges.get(i).to == to) {
                return edges.get(i).weigth;
            }
        }
        throw new IllegalArgumentException("No such edge");
    }

    @Override
    public List<Edge> neighbors(int v) {
        return graph[v];
    }

    @Override
    public int size() {
        return graph.length;
    }
    
}
