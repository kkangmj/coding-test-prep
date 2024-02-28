/**
 * 프림 알고리즘
 * 실행 시간: 2376ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1647 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int numOfHouse = Integer.parseInt(st.nextToken());
    int numOfRoad = Integer.parseInt(st.nextToken());
    ArrayList<Node>[] nodes = new ArrayList[numOfHouse + 1];
    for (int i = 1; i <= numOfHouse; i++) {
      nodes[i] = new ArrayList<>();
    }

    for (int i = 0; i < numOfRoad; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      nodes[v1].add(new Node(v2, w));
      nodes[v2].add(new Node(v1, w));
    }

    // 프림 알고리즘
    PriorityQueue<Node> pq = new PriorityQueue<>();
    boolean[] visited = new boolean[numOfHouse + 1];
    pq.add(new Node(1, 0));
    int dist = 0;
    int numOfVisitedNode = 0;
    int maxWeight = 0;

    while (!pq.isEmpty()) {
      Node node = pq.poll();
      int v = node.v;
      int w = node.w;

      if (visited[v]) {
        continue;
      }

      visited[v] = true;
      numOfVisitedNode++;
      dist += w;
      maxWeight = Math.max(maxWeight, w);

      if (numOfVisitedNode >= numOfHouse) {
        break;
      }

      for (Node linkedNode : nodes[v]) {
        if (!visited[linkedNode.v]) {
          pq.add(linkedNode);
        }
      }
    }

    System.out.println(dist - maxWeight);
  }

  static class Node implements Comparable<Node> {

    private int v;
    private int w;

    private Node(int v, int w) {
      this.v = v;
      this.w = w;
    }

    @Override
    public int compareTo(Node node) {
      return this.w - node.w;
    }
  }
}
