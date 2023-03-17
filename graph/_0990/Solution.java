package graph._0990;

public class Solution {
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        for (String eq:equations){
            if (eq.charAt(1) == '='){
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                uf.union(x - 'a', y - 'a');
            }
        }
        for (String eq:equations){
            if (eq.charAt(1) == '!'){
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                if (uf.connected(x - 'a', y - 'a'))
                    return false;
            }
        }
        return true;
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
