/**
 * 빵집
 */

import java.util.*;
import java.io.*;

public class Main_3109 {

  private static int row;
  private static int column;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    row = Integer.parseInt(st.nextToken());
    column = Integer.parseInt(st.nextToken());
    int count = 0;
    boolean[][] visited = new boolean[row][column];

    for (int i = 0; i < row; i++) {
      String line = br.readLine();
      for (int j = 0; j < column; j++) {
        if (line.charAt(j) == 'x') {
          visited[i][j] = true;
        }
      }
    }

    for (int i = 0; i < row; i++) {
      if (dfs(i, 0, visited)) {
        count++;
      }
    }

    System.out.println(count);
  }

  private static boolean dfs(int rowIndex, int columnIndex, boolean[][] visited) {
    visited[rowIndex][columnIndex] = true;

    if (columnIndex == column - 1) {
      return true;
    }

    if (rowIndex - 1 >= 0 && !visited[rowIndex - 1][columnIndex + 1]) {
      if (dfs(rowIndex - 1, columnIndex + 1, visited)) {
        return true;
      }
    }
    if (!visited[rowIndex][columnIndex + 1]) {
      if (dfs(rowIndex, columnIndex + 1, visited)) {
        return true;
      }
    }
    if (rowIndex + 1 < row && !visited[rowIndex + 1][columnIndex + 1]) {
      if (dfs(rowIndex + 1, columnIndex + 1, visited)) {
        return true;
      }
    }
    return false;
  }
}
