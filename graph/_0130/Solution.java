package graph._0130;

public class Solution {
    public void solve(char[][] board) {
        if (board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        UF uf = new UF(m * n + 1);
        int dummy = m * n;
        for (int i = 0; i < m; i++){
            if (board[i][0] == 'O')
                uf.union(i * n, dummy);
            if (board[i][n - 1] == 'O')
                uf.union(i * n + n - 1, dummy);
        }
        for (int j = 0; j < n; j++){
            if (board[0][j] == 'O')
                uf.union(j, dummy);
            if (board[m - 1][j] == 'O')
                uf.union((m - 1) * n + j, dummy);
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 1; i < m - 1; i++){
            for (int j = 1; j < n - 1; j++){
                if (board[i][j] == 'O'){
                    for (int[] direction:directions){
                        int x = i + direction[0];
                        int y = j + direction[1];
                        if (board[x][y] == 'O')
                            uf.union(x * n + y, i * n + j);
                    }
                }
            }
        }
        for (int i = 1; i < m - 1; i++)
            for (int j = 1; j < n - 1; j++)
                if (!uf.connected(dummy, i * n + j))
                    board[i][j] = 'X';
    }
}
class UF{
    private int count;
    private int parent[];
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