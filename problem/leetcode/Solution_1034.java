/*
 * 1034. Coloring A Border
 * Runtime: 1ms, Memory: 54MB
 */

import java.util.Arrays;

public class Solution_1034 {

  public static void main(String[] args) {
    Solution_1034 solution_1034 = new Solution_1034();
    int[][] grid = {{1, 2, 1, 2, 1, 2}, {2, 2, 2, 2, 1, 2}, {1, 2, 2, 2, 1, 2}};
    System.out.println(Arrays.deepToString(solution_1034.colorBorder(grid, 1, 3, 1)));
  }

  private int TARGET_COLOR;
  private int NEW_COLOR;
  private int ROW;
  private int COL;

  private final int[] op1 = {0, 0, -1, 1};
  private final int[] op2 = {1, -1, 0, 0};

  public int[][] colorBorder(int[][] grid, int row, int col, int color) {
    TARGET_COLOR = grid[row][col];
    NEW_COLOR = color;
    ROW = grid.length;
    COL = grid[0].length;

    boolean[][] visited = new boolean[ROW][COL];

    dfs(row, col, grid, visited);

    return grid;
  }

  private void dfs(int x, int y, int[][] grid, boolean[][] visited) {
    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int newX = x + op1[i];
      int newY = y + op2[i];

      if (newX >= 0 && newX < ROW && newY >= 0 && newY < COL && !visited[newX][newY]
          && grid[newX][newY] == TARGET_COLOR) {
        dfs(newX, newY, grid, visited);
      }
    }

    if (isBorder(x, y, visited)) {
      grid[x][y] = NEW_COLOR;
    }
  }

  private boolean isBorder(int x, int y, boolean[][] visited) {
    int border = 0;

    for (int i = 0; i < 4; i++) {
      int newX = x + op1[i];
      int newY = y + op2[i];

      if (newX >= 0 && newX < ROW && newY >= 0 && newY < COL && visited[newX][newY]) {
        border++;
      }
    }

    return border != 4;
  }
}
