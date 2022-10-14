/*
가장 먼 노드 - 다익스트라
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_49189 {

  public static void main(String[] args) {
    Solution_49189 solution_49189 = new Solution_49189();
    int n = 6;
    int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
    System.out.println(solution_49189.solution(n, vertex));
  }


  public int solution(int n, int[][] edge) {

    ArrayList<Integer>[] graph = new ArrayList[n + 1];

    for (int i = 1; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] e : edge) {
      int x = e[0];
      int y = e[1];

      graph[x].add(y);
      graph[y].add(x);
    }

    int[] dist = new int[n + 1];
    Arrays.fill(dist, 50001);
    dist[1] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(1, dist[1]));

    while (!pq.isEmpty()) {
      Node node = pq.poll();
      int indexOfNode = node.index;
      int distOfNode = node.dist;

      if (dist[indexOfNode] < distOfNode) {
        continue;
      }

      for (int i = 1; i <= n; i++) {
        int newCalculated = dist[indexOfNode] + 1;
        if (graph[indexOfNode].contains(i) && newCalculated < dist[i]) {
          dist[i] = newCalculated;
          pq.add(new Node(i, newCalculated));
        }
      }
    }

    int maxDist = 0;
    int answer = 0;

    for (int i = 2; i <= n; i++) {
      if (maxDist == dist[i]) {
        answer++;
      } else if (maxDist < dist[i]) {
        answer = 1;
        maxDist = dist[i];
      }
    }

    return answer;
  }

  static class Node implements Comparable<Node> {

    private final int index;
    private final int dist;

    Node(int index, int dist) {
      this.index = index;
      this.dist = dist;
    }

    @Override
    public int compareTo(Node node) {
      return this.dist - node.dist;
    }
  }
}
