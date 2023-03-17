package graph._0743;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph[from].add(new int[]{to, weight});
        }
        int[] distTo = dijkstra(k, graph);
        int res = 0;
        for (int i = 1; i < distTo.length; i++) {
            if (distTo[i] == Integer.MAX_VALUE) {
                return -1;
            }
            res = Math.max(res, distTo[i]);
        }
        return res;
    }
    int[] dijkstra(int start, List<int[]>[] graph){
        int[] distto = new int[graph.length];
        Arrays.fill(distto, Integer.MAX_VALUE);
        distto[start] = 0;
        Queue<State> pq = new PriorityQueue<>((a, b) -> {return a.distFromStart - b.distFromStart;});
        pq.offer(new State(start, 0));
        while (!pq.isEmpty()){
            State curstate = pq.poll();
            int curnodeid = curstate.id;
            int curdistfromstart = curstate.distFromStart;
            if (curdistfromstart > distto[curnodeid]){
                continue;
            }
            for (int[] neighbor:graph[curnodeid]){
                int nextnodeid = neighbor[0];
                int disttonextnode = distto[curnodeid] + neighbor[1];
                if (distto[nextnodeid] > disttonextnode){
                    distto[nextnodeid] = disttonextnode;
                    pq.offer(new State(nextnodeid, disttonextnode));
                }
            }
        }
        return distto;
    }
}
class State {
    int id;
    int distFromStart;
    State(int id, int distFromStart) {
        this.id = id;
        this.distFromStart = distFromStart;
    }
}

