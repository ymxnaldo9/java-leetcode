package graph._0323;

public class Solution {
    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] e:edges)
            uf.union(e[0], e[1]);
        return uf.count();
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
