package leetcode.editor.vip;

import leetcode.editor.my.UF;

public class _0261Solution {
    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);

        for(int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            // 如果 from，to 已经在一个连通分量里，再连接将会成环
            if (uf.connected(from, to)) {
                return false;
            } 
            
            uf.union(from, to);
        }

        // 总的连通分量为 1 且无环，则为树
        return uf.count() == 1;
    }
}
