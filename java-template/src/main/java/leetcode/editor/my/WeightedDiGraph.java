package leetcode.editor.my;

import java.util.LinkedList;
import java.util.List;

public class WeightedDiGraph implements Graph {
    private int[][] matrix;  
    public WeightedDiGraph(int n) {
        matrix = new int[n][n];
    }

    @Override
    public void addEdge(int from, int to, int weigth) {
        matrix[from][to] = weigth;
    }

    @Override
    public void removeEdge(int from, int to) {
        matrix[from][to] = 0;
    }

    @Override
    public boolean hasEdge(int from, int to) {
        return matrix[from][to] != 0;
    }

    @Override
    public int weigth(int from, int to) {
        return matrix[from][to];
    }

    @Override
    public List<Edge> neighbors(int v) {
        List<Edge> neighbors = new LinkedList<>();
        for(int i = 0; i < matrix.length; i++) {
            if (matrix[v][i] != 0) {
                neighbors.add(new Edge(i, matrix[v][i]));
            }
        }
        return neighbors;
    }

    @Override
    public int size() {
       return matrix.length;
    }


}
