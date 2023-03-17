package graph._0886;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private boolean ispossible = true;
    private boolean[] color;
    private boolean[] visited;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        color = new boolean[n + 1];
        visited = new boolean[n + 1];
        List<Integer>[] graph = buildgraph(n, dislikes);
        for (int i = 1; i <= n; i++)
            if (!visited[i])
                traverse(graph, i);
        return ispossible;
    }
    private List<Integer>[] buildgraph(int n, int[][] dislikes){
        List<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++){
            graph[i] = new LinkedList<>();
        }
        for (int[] edge:dislikes){
            int v = edge[1];
            int w = edge[0];
            graph[w].add(v);
            graph[v].add(w);
        }
        return graph;
    }
    private void traverse(List<Integer>[] graph, int v){
        if (!ispossible)
            return;
        visited[v] = true;
        for (int w:graph[v]){
            if (!visited[w]){
                color[w] = !color[v];
                traverse(graph, w);
            }
            else{
                if (color[w] == color[v]){
                    ispossible = false;
                    return;
                }
            }
        }
    }
}
