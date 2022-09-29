public class Solution_77485 {

  public static void main(String[] args) {
    Solution_77485 solution_77485 = new Solution_77485();
    int rows = 6;
    int columns = 6;
    int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6,}, {5, 1, 6, 3}};
    System.out.println(solution_77485.solution(rows, columns, queries));
  }

  public int[] solution(int rows, int columns, int[][] queries) {
    int[] answer = new int[queries.length];
    int[][] matrix = new int[rows + 1][columns + 1];

    int value = 1;
    int index = 0;

    for (int i = 0; i <= rows; i++) {
      for (int j = 0; j <= columns; j++) {
        if (i == 0 || j == 0) {
          matrix[i][j] = 0;
          continue;
        }
        matrix[i][j] = value;
        value++;
      }
    }

    for (int[] query : queries) {
      int minNum = Integer.MAX_VALUE;
      int current = 0;
      int toBeChanged = 0;

      // 위쪽 라인 - 오른쪽으로 이동
      int fixedX = query[0];
      current = matrix[fixedX][query[1]];

      for (int y = query[1] + 1; y <= query[3]; y++) {
        minNum = Math.min(minNum, current);
        toBeChanged = matrix[fixedX][y];
        matrix[fixedX][y] = current;
        current = toBeChanged;
      }

      // 오른쪽 라인 - 아래로 이동
      int fixedY = query[3];

      for (int x = query[0] + 1; x <= query[2]; x++) {
        minNum = Math.min(minNum, current);
        toBeChanged = matrix[x][fixedY]; // 16
        matrix[x][fixedY] = current;
        current = toBeChanged;
      }

      // 아래쪽 라인 - 왼쪽으로 이동
      fixedX = query[2];

      for (int y = query[3] - 1; y >= query[1]; y--) {
        minNum = Math.min(minNum, current);
        toBeChanged = matrix[fixedX][y];
        matrix[fixedX][y] = current;
        current = toBeChanged;
      }

      // 왼쪽 라인 - 위쪽으로 이동
      fixedY = query[1];

      for (int x = query[2] - 1; x >= query[0]; x--) {
        minNum = Math.min(minNum, current);
        toBeChanged = matrix[x][fixedY];
        matrix[x][fixedY] = current;
        current = toBeChanged;
      }

      answer[index] = minNum;
      index++;
    }

    return answer;
  }
}
