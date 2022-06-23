/**
 * 다익스트라 알고리즘
 * 실행 시간: 88ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_10473 {

  private final static int INF = 1000001;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    Point startPoint = new Point(Double.parseDouble(st.nextToken()),
        Double.parseDouble(st.nextToken()));

    st = new StringTokenizer(br.readLine());
    Point endPoint = new Point(Double.parseDouble(st.nextToken()),
        Double.parseDouble(st.nextToken()));

    int numOfCannon = Integer.parseInt(br.readLine());
    Point[] points = new Point[numOfCannon + 2];
    points[0] = startPoint;
    points[numOfCannon + 1] = endPoint;

    for (int i = 1; i <= numOfCannon; i++) {
      st = new StringTokenizer(br.readLine());
      points[i] = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
    }

    PriorityQueue<Node> pq = new PriorityQueue<>();
    double[] minTime = new double[numOfCannon + 2];

    for (int i = 1; i < minTime.length; i++) {
      minTime[i] = INF;
    }

    pq.offer(new Node(0, 0));

    while (!pq.isEmpty()) {
      Node node = pq.poll();
      double timeOfNode = node.time;
      int indexOfNode = node.index;

      if (timeOfNode > minTime[indexOfNode]) {
        continue;
      }

      for (int i = 1; i < points.length; i++) {
        double temp = minTime[indexOfNode] + getMinTime(indexOfNode, i, points);
        if (temp < minTime[i]) {
          minTime[i] = temp;
          pq.offer(new Node(temp, i));
        }
      }
    }

    System.out.println(minTime[numOfCannon + 1]);
  }

  private static double getMinTime(int indexOfPointA, int indexOfPointB, Point[] points) {

    Point a = points[indexOfPointA];
    Point b = points[indexOfPointB];

    double distance = Math.sqrt(Math.pow(a.x - b.x, 2.0) + Math.pow(a.y - b.y, 2.0));

    if (indexOfPointA == 0) {
      return distance / 5.0;
    }

    return Math.min(2 + Math.abs(distance - 50) / 5.0, distance / 5.0);
  }

  static class Point {

    private final double x;
    private final double y;

    public Point(double x, double y) {
      this.x = x;
      this.y = y;
    }
  }

  static class Node implements Comparable<Node> {

    private double time;
    private int index;

    public Node(double time, int index) {
      this.time = time;
      this.index = index;
    }

    @Override
    public int compareTo(Node node) {
      return (int) (this.time - node.time);
    }
  }
}

