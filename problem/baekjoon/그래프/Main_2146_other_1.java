/**
 * dfs로 섬에게 고유 번호를 붙여주고, bfs로 탐색해 나가며 다른 고유번호를 가진 섬에 다다르면 minDistance를 업데이트
 *
 * 실행 시간: 240ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2146_other_1 {

  private static final int[] op1 = {0, 0, 1, -1};
  private static final int[] op2 = {1, -1, 0, 0};
  private static int N;
  private static int minDistance = 10000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    int[][] map = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int indexOfLand = 2;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 1) {
          map[i][j] = indexOfLand;
          dfs(i, j, indexOfLand, map);
          indexOfLand++;
        }

        if (map[i][j] != 0 && isEdge(i, j, map)) {
          bfs(i, j, map);
        }
      }
    }

    System.out.println(minDistance);
  }

  private static void bfs(int x, int y, int[][] map) {
    Queue<Point> queue = new LinkedList<>();
    queue.add(new Point(x, y, 0));

    boolean[][] visited = new boolean[N][N];
    visited[x][y] = true;

    while (!queue.isEmpty()) {
      Point point = queue.poll();
      int pointX = point.x;
      int pointY = point.y;
      int pointDistance = point.distance;

      if (minDistance <= pointDistance) {
        return;
      }

      for (int i = 0; i < 4; i++) {
        int newX = pointX + op1[i];
        int newY = pointY + op2[i];

        if (isValid(newX, newY) && !visited[newX][newY]) {
          if (map[newX][newY] == 0) {
            visited[newX][newY] = true;
            queue.add(new Point(newX, newY, pointDistance + 1));
          } else if (map[x][y] != map[newX][newY]) {
            minDistance = Math.min(minDistance, pointDistance);
          }
        }
      }
    }
  }

  private static boolean isEdge(int x, int y, int[][] map) {
    for (int i = 0; i < 4; i++) {
      int newX = x + op1[i];
      int newY = y + op2[i];

      if (isValid(newX, newY) && map[newX][newY] == 0) {
        return true;
      }
    }

    return false;
  }

  private static void dfs(int x, int y, int t, int[][] map) {
    for (int i = 0; i < 4; i++) {
      int newX = x + op1[i];
      int newY = y + op2[i];

      if (isValid(newX, newY) && map[newX][newY] == 1) {
        map[newX][newY] = t;
        dfs(newX, newY, t, map);
      }
    }
  }

  private static boolean isValid(int x, int y) {
    return x >= 0 && x < N && y >= 0 && y < N;
  }

  private static class Point {

    private int x;
    private int y;
    private int distance;

    private Point(int x, int y, int distance) {
      this.x = x;
      this.y = y;
      this.distance = distance;
    }
  }
}
