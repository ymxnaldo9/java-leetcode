package graph._0785;

public class Solution {
    private boolean isbipar = true;
    private boolean[] color;
    private boolean[] visited;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new boolean[n];
        visited = new boolean[n];
        for (int v = 0; v < n; v++){
            if (!visited[v])
                traverse(graph, v);
        }
        return isbipar;
    }
    private void traverse(int[][] graph, int v){
        if (!isbipar)
            return;
        visited[v] = true;
        for (int w:graph[v]){
            if (!visited[w]){
                color[w] = !color[v];
                traverse(graph, w);
            }
            else{
                if (color[w] == color[v]){
                    isbipar = false;
                    return;
                }
            }
        }
    }
}
