package graph._0207;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public boolean visited[];
    public boolean onpath[];
    private boolean hascycle;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildgraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onpath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++)
            traverse(graph, i);
        return !hascycle;
    }
    private List<Integer>[] buildgraph(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new LinkedList<>();
        for (int[] edge:prerequisites){
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }
    private void traverse(List<Integer>[] graph, int s){
        if (onpath[s])
            hascycle = true;
        if (visited[s] || hascycle)
            return;
        visited[s] = true;
        onpath[s] = true;
        for (int t:graph[s])
            traverse(graph, t);
        onpath[s] = false;
    }
}
