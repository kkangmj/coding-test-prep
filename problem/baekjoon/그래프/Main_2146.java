/**
 * dfs로 섬의 edge를 찾아서 map에 섬 번호, edge 포인트를 담은 리스트 저장
 * 각 섬의 edge 포인트 거리 계산하며 최소값 찾기 (완전탐색 방식)
 *
 * 실행 시간: 500ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_2146 {

  private static final int[] op1 = {0, 0, 1, -1};
  private static final int[] op2 = {1, -1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] map = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    HashMap<Integer, ArrayList<Point>> edgeOfLands = new HashMap<>();
    boolean[][] visited = new boolean[N][N];
    int indexOfLand = 1;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 1 && !visited[i][j]) {
          if (isEdge(i, j, N, map)) {
            ArrayList<Point> points = edgeOfLands.getOrDefault(indexOfLand, new ArrayList<>());
            points.add(new Point(i, j));
            edgeOfLands.put(indexOfLand, points);
          }

          dfs(i, j, N, indexOfLand, map, edgeOfLands, visited);
          indexOfLand++;
        }
      }
    }

    int answer = 10000;

    for (int i = 1; i < indexOfLand; i++) {
      ArrayList<Point> land1 = edgeOfLands.get(i);
      for (int j = i + 1; j < indexOfLand; j++) {
        ArrayList<Point> land2 = edgeOfLands.get(j);
        answer = Math.min(answer, getMinDistance(land1, land2));
        if (answer == 1) {
          break;
        }
      }
    }

    System.out.println(answer - 1);
  }

  private static int getMinDistance(ArrayList<Point> land1, ArrayList<Point> land2) {
    int min = 10000;

    for (int i = 0; i < land1.size(); i++) {
      Point point1 = land1.get(i);
      for (int j = 0; j < land2.size(); j++) {
        Point point2 = land2.get(j);
        min = Math.min(min, Math.abs(point1.x - point2.x) + Math.abs(point1.y - point2.y));
      }
    }

    return min;
  }

  private static void dfs(int x, int y, int N, int index, int[][] map,
      HashMap<Integer, ArrayList<Point>> edges,
      boolean[][] visited) {
    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int newX = x + op1[i];
      int newY = y + op2[i];

      if (newX >= 0 && newX < N && newY >= 0 && newY < N && !visited[newX][newY]
          && map[newX][newY] == 1) {
        if (isEdge(newX, newY, N, map)) {
          ArrayList<Point> points = edges.getOrDefault(index, new ArrayList<>());
          points.add(new Point(newX, newY));
          edges.put(index, points);
        }
        dfs(newX, newY, N, index, map, edges, visited);
      }
    }
  }

  private static boolean isEdge(int x, int y, int N, int[][] map) {
    for (int i = 0; i < 4; i++) {
      int newX = x + op1[i];
      int newY = y + op2[i];

      if (newX >= 0 && newX < N && newY >= 0 && newY < N && map[newX][newY] == 0) {
        return true;
      }
    }

    return false;
  }

  private static class Point {

    private int x;
    private int y;

    private Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
