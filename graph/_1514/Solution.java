package graph._1514;

import java.util.List;
import java.util.Queue;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.LinkedList;

public class Solution {
    double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double weight = succProb[i];
            graph[from].add(new double[]{(double)to, weight});
            graph[to].add(new double[]{(double)from, weight});
        }
        return dijkstra(start, end, graph);
    }
    double dijkstra(int start, int end, List<double[]>[] graph) {
        double[] probTo = new double[graph.length];
        Arrays.fill(probTo, -1);
        probTo[start] = 1;
        Queue<State> pq = new PriorityQueue<>((a, b) -> {return Double.compare(b.probFromStart, a.probFromStart);});
        pq.offer(new State(start, 1));
        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNodeID = curState.id;
            double curProbFromStart = curState.probFromStart;
            if (curNodeID == end) {
                return curProbFromStart;
            }
            if (curProbFromStart < probTo[curNodeID]) {
                continue;
            }
            for (double[] neighbor : graph[curNodeID]) {
                int nextNodeID = (int)neighbor[0];
                double probToNextNode = probTo[curNodeID] * neighbor[1];
                if (probTo[nextNodeID] < probToNextNode) {
                    probTo[nextNodeID] = probToNextNode;
                    pq.offer(new State(nextNodeID, probToNextNode));
                }
            }
        }
        return 0.0;
    }
}
class State {
    int id;
    double probFromStart;
    State(int id, double probFromStart) {
        this.id = id;
        this.probFromStart = probFromStart;
    }
}