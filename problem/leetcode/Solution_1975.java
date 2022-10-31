/*
 * 1975. Maximum Matrix Sum
 * Runtime: 14ms, Memory: 85.7MB
 *
 * 아래와 같은 규칙을 갖고 있음.
 * 음수의 개수가 짝수라면 모든 음수를 양수로 변경할 수 있으며, 음수의 개수가 홀수라면 무조건 1개의 값은 음수로 남아 있음.
 * 따라서, 남아야 하는 1개의 값을 matrix 최소값으로 지정하면 됨.
 */


public class Solution_1975 {

  public long maxMatrixSum(int[][] matrix) {
    int negativeNum = 0;
    int minNum = 100001;
    long sumOfMatrix = 0;
    int n = matrix.length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int value = matrix[i][j];

        if (value < 0) {
          negativeNum++;
          value *= -1;
        }

        minNum = Math.min(minNum, value);
        sumOfMatrix += value;
      }
    }

    if (negativeNum % 2 != 0) {
      sumOfMatrix -= minNum * 2L;
    }

    return sumOfMatrix;
  }
}
