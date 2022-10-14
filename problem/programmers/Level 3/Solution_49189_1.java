/*
가장 먼 노드 - bfs
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_49189_1 {

  public static void main(String[] args) {
    Solution_49189_1 solution_49189_1 = new Solution_49189_1();
    int n = 6;
    int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
    System.out.println(solution_49189_1.solution(n, vertex));
  }

  private static ArrayList<Integer>[] graph;
  private static boolean[] visited;
  private static int[] dist;

  public int solution(int n, int[][] edge) {

    graph = new ArrayList[n + 1];
    dist = new int[n + 1];
    visited = new boolean[n + 1];

    for (int i = 1; i < n + 1; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] e : edge) {
      int x = e[0];
      int y = e[1];

      graph[x].add(y);
      graph[y].add(x);
    }

    Arrays.fill(dist, 50001);
    dist[1] = 0;

    bfs(1);

    int maxDist = 0;
    int answer = 0;

    for (int i = 2; i < n + 1; i++) {
      if (maxDist == dist[i]) {
        answer++;
      } else if (maxDist < dist[i]) {
        answer = 1;
        maxDist = dist[i];
      }
    }

    return answer;
  }

  private void bfs(int node) {
    Queue<Integer> queue = new LinkedList<>();
    visited[node] = true;
    queue.add(node);

    while (!queue.isEmpty()) {
      Integer currentNode = queue.poll();

      for (int nextNode : graph[currentNode]) {
        if (!visited[nextNode]) {
          dist[nextNode] = dist[currentNode] + 1;
          queue.add(nextNode);
          visited[nextNode] = true;
        }
      }
    }
  }
}
