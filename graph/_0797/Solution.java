package graph._0797;
import java.util.*;

public class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }
    void traverse(int[][] graph, int s, LinkedList<Integer> path) {
        path.addLast(s);
        if (s == graph.length - 1)
            res.add(new LinkedList<>(path));
        for (int v:graph[s])
            traverse(graph, v, path);
        path.removeLast();
    }
}
