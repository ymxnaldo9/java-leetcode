package graph._1584;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int xi = points[i][0];
                int yi = points[i][1];
                int xj = points[j][0];
                int yj = points[j][1];
                edges.add(new int[] {i, j, Math.abs(xi - xj) + Math.abs(yi - yj)});
            }
        }
        UF uf = new UF(n);
        Collections.sort(edges, (a, b) -> (a[2] - b[2]));
        int mst = 0;
        for (int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if (uf.connected(u, v))
                continue;
            uf.union(u, v);
            mst += weight;
        }
        return mst;
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