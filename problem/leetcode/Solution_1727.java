/*
 * 1727. Largest Submatrix With Rearrangements
 * Runtime: 15ms, Memory: 90.7MB
 *
 * Solution:
 * (1) Change matrix element with cumulative value
 *    [[0, 0, 0, 1],         [[0, 0, 0, 1],
 *     [1, 0, 1, 1],   =>     [1, 0, 1, 2],
 *     [0, 1, 1, 1],          [0, 1, 2, 3],
 *     [0, 1, 1, 1]]          [0, 2, 3, 4]]
 * (2) Sort each row and find possible matrix size
 *    [[0, 0, 0, 1],         [[0, 0, 0, 1],          Possible size: 1 * 1
 *     [1, 0, 1, 2],   =>     [0, 1, 1, 2],   =>     Possible size: 2 * 1, 1* 3
 *     [0, 1, 2, 3],          [0, 1, 2, 3],          Possible size: 3 * 1, 2 * 2, 1 * 3
 *     [0, 2, 3, 4]]          [0, 2, 3, 4]]          Possible size: 4 * 1, 3 * 2, 2 * 3
 */

import java.util.Arrays;

public class Solution_1727 {

  public static void main(String[] args) {
    Solution_1727 solution_1727 = new Solution_1727();
    int[][] matrix = {{0, 1, 1, 0}, {1, 1, 1, 1}, {0, 0, 0, 1}, {1, 1, 1, 1}};
    System.out.println(solution_1727.largestSubmatrix(matrix));
  }

  public int largestSubmatrix(int[][] matrix) {

    int N = matrix.length;
    int M = matrix[0].length;

    for (int i = 1; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (matrix[i][j] == 1) {
          matrix[i][j] = matrix[i - 1][j] + 1;
        }
      }
    }

    int answer = 0;
    int previousValue;

    for (int i = 0; i < N; i++) {
      Arrays.sort(matrix[i]);
      previousValue = 0;

      for (int j = 0; j < M; j++) {
        int currentValue = matrix[i][j];

        if (currentValue != previousValue) {
          answer = Math.max(answer, currentValue * (M - j));
          previousValue = currentValue;
        }
      }
    }

    return answer;
  }
}
