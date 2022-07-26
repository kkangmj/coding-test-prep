/**
 * 74. Search a 2D Matrix
 */

public class Solution_74 {

  public boolean searchMatrix(int[][] matrix, int target) {
    int M = matrix.length;
    int N = matrix[0].length;

    return binarySearch(matrix, target, M, N);

  }

  private boolean binarySearch(int[][] matrix, int target, int M, int N) {
    int pl = 0;
    int pr = M * N - 1;

    do {
      int pc = (pl + pr) / 2;
      int matrixValue = convertTo(matrix, pc, N);
      if (matrixValue == target) {
        return true;
      } else if (matrixValue > target) {
        pr = pc - 1;
      } else {
        pl = pc + 1;
      }
    } while (pl <= pr);

    return false;
  }

  private int convertTo(int[][] matrix, int p, int N) {
    return matrix[p / N][p % N];
  }
}
