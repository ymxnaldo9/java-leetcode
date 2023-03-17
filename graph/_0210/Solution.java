package graph._0210;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> postorder = new ArrayList<>();
    public boolean hascycle = false;
    private boolean[] visited;
    private boolean[] onpath;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildgraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onpath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++)
            traverse(graph, i);
        if (hascycle)
            return new int[]{};
        Collections.reverse(postorder);
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            res[i] = postorder.get(i);
        return res;
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
        postorder.add(s);
        onpath[s] = false;
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
}
