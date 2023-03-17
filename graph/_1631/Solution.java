package graph._1631;

import java.util.Arrays;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
    List<int[]> adj(int[][] matrix, int x, int y){
        int m = matrix.length;
        int n = matrix[0].length;
        List<int[]> neighbors = new ArrayList<>();
        for (int[] dir:dirs){
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= m || nx < 0 || ny >= n || ny < 0) {
                continue;
            }
            neighbors.add(new int[]{nx, ny});
        }
        return neighbors;
    }
    public int minimumEffortPath(int[][] heights){
        int m = heights.length;
        int n = heights[0].length;
        int[][] effortto = new int[m][n];
        for (int i = 0; i < m; i++){
            Arrays.fill(effortto[i], Integer.MAX_VALUE);
        }
        effortto[0][0] = 0;
        Queue<State> pq = new PriorityQueue<>((a, b) -> {return a.effortfromstart - b.effortfromstart;});
        pq.offer(new State(0, 0, 0));
        while (!pq.isEmpty()){
            State curState = pq.poll();
            int curX = curState.x;
            int curY = curState.y;
            int curEffortFromStart = curState.effortfromstart;
            if (curX == m - 1 && curY == n - 1){
                return curEffortFromStart;
            }
            if (curEffortFromStart > effortto[curX][curY]){
                continue;
            }
            for (int[] neighbor : adj(heights, curX, curY)){
                int nextX = neighbor[0];
                int nextY = neighbor[1];
                int effortToNextNode = Math.max(
                        effortto[curX][curY],
                        Math.abs(heights[curX][curY] - heights[nextX][nextY])
                );
                if (effortto[nextX][nextY] > effortToNextNode) {
                    effortto[nextX][nextY] = effortToNextNode;
                    pq.offer(new State(nextX, nextY, effortToNextNode));
                }
            }
        }
        return -1;
    }
}
class State{
    int x;
    int y;
    int effortfromstart;
    State(int x, int y, int effortfromstart){
        this.x = x;
        this.y = y;
        this.effortfromstart = effortfromstart;
    }
}
