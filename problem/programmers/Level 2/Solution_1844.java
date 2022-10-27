/*
게임 맵 최단거리
 */

import java.util.LinkedList;
import java.util.Queue;

public class Solution_1844 {

  public static void main(String[] args) {
    Solution_1844 solution_1844 = new Solution_1844();
    int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1},
        {0, 0, 0, 0, 1}};
    System.out.println(solution_1844.solution(maps));
  }

  private static final int[] op1 = {-1, 1, 0, 0};
  private static final int[] op2 = {0, 0, 1, -1};

  private static int n;
  private static int m;

  public int solution(int[][] maps) {

    n = maps.length;
    m = maps[0].length;

    boolean[][] visited = new boolean[n][m];

    return bfs(0, 0, maps, visited);
  }

  private int bfs(int x, int y, int[][] maps, boolean[][] visited) {
    Queue<Position> queue = new LinkedList<>();
    queue.add(new Position(x, y, 0));
    visited[x][y] = true;

    while (!queue.isEmpty()) {
      Position p = queue.poll();

      if (p.x == n - 1 && p.y == m - 1) {
        return p.move + 1;
      }

      for (int i = 0; i < 4; i++) {
        int newX = p.x + op1[i];
        int newY = p.y + op2[i];

        if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY]
            && maps[newX][newY] == 1) {
          visited[newX][newY] = true;
          queue.add(new Position(newX, newY, p.move + 1));
        }
      }
    }

    return -1;
  }


  static class Position {

    private int x;
    private int y;
    private int move;

    Position(int x, int y, int move) {
      this.x = x;
      this.y = y;
      this.move = move;
    }
  }
}
