/**
 * 1742. Maximum Number of Balls in a Box
 * Runtime: 54ms, Memory: 46.1MB
 */

public class Solution_1742 {

  public int countBalls(int lowLimit, int highLimit) {
    int[] box = new int[46];
    int answer = 0;

    for (int i = lowLimit; i <= highLimit; i++) {
      int value = i;
      int sum = 0;

      if (value / 100000 != 0) {
        sum += value / 100000;
        value %= 100000;
      }

      if (value / 10000 != 0) {
        sum += value / 10000;
        value %= 10000;
      }

      if (value / 1000 != 0) {
        sum += value / 1000;
        value %= 1000;
      }

      if (value / 100 != 0) {
        sum += value / 100;
        value %= 100;
      }

      if (value / 10 != 0) {
        sum += value / 10;
        value %= 10;
      }

      sum += value;
      box[sum] += 1;
      answer = Math.max(answer, box[sum]);
    }

    return answer;
  }
}
