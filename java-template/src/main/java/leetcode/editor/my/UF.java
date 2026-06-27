package leetcode.editor.my;

/**
 * 带路径压缩实现的并查集
*/
public class UF {

    // 连通分量的个数
    private int count;

    // 父节点数组，每个连通分量有且只有一个父节点
    private int[] parent;

    // 各连通分量里节点数量
    private int[] size;

    public UF(int nums) {
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
