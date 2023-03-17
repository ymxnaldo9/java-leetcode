package graph._1135;

import java.util.Arrays;

public class Solution {
    public int minimumCost(int n, int[][] connections) {
        UF uf = new UF(n + 1);
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));
        int mst = 0;
        for (int[] connection:connections){
            int u = connection[0];
            int v = connection[1];
            int weight = connection[2];
            if (uf.connected(u, v))
                continue;
            uf.union(u, v);
            mst += weight;
        }
        return uf.count() == 2 ? mst : -1;
    }
}
class UF{
    private int count;
    private int[] parent;
    public UF(int n){
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }
    public void union(int p, int q){
        int rootp = find(p);
        int rootq = find(q);
        if (rootp == rootq)
            return;
        parent[rootq] = rootp;
        count--;
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    public int find(int x){
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
    public int count(){
        return count;
    }
}