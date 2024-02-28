/**
 * 크루스칼 알고리즘
 * 실행 시간: 1340ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1647_other_1 {

  private static int[] unionParent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int numOfHouse = Integer.parseInt(st.nextToken());
    int numOfRoad = Integer.parseInt(st.nextToken());

    PriorityQueue<Node> pq = new PriorityQueue<>();
    for (int i = 0; i < numOfRoad; i++) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      pq.add(new Node(v1, v2, w));
    }

    unionParent = new int[numOfHouse + 1];
    for (int i = 0; i <= numOfHouse; i++) {
      unionParent[i] = i;
    }

    int includedNode = 0;
    int totalCost = 0;
    int maxCost = 0;

    while (includedNode < numOfHouse - 1 && !pq.isEmpty()) {
      Node node = pq.poll();
      int v1 = node.v1;
      int v2 = node.v2;
      int w = node.w;

      if (findParent(v1) != findParent(v2)) {
        unionHome(v1, v2);
        totalCost += w;
        includedNode++;
        maxCost = Math.max(maxCost, w);
      }
    }
    System.out.println(totalCost - maxCost);
  }

  private static int findParent(int v) {
    if (v == unionParent[v]) {
      return v;
    }
    unionParent[v] = findParent(unionParent[v]);
    return unionParent[v];
  }

  private static int unionHome(int v1, int v2) {
    int a = findParent(v1);
    int b = findParent(v2);

    if (a < b) {
      return unionParent[b] = a;
    } else {
      return unionParent[a] = b;
    }
  }

  static class Node implements Comparable<Node> {

    private int v1;
    private int v2;
    private int w;

    private Node(int v1, int v2, int w) {
      this.v1 = v1;
      this.v2 = v2;
      this.w = w;
    }

    @Override
    public int compareTo(Node node) {
      return this.w - node.w;
    }
  }
}
