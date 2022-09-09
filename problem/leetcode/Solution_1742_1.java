/**
 * 1742. Maximum Number of Balls in a Box
 * Runtime: 84ms, Memory: 50.3MB
 */

import java.util.HashMap;
import java.util.Map;

public class Solution_1742_1 {

  public int countBalls(int lowLimit, int highLimit) {
    Map<Integer, Integer> box = new HashMap<>();
    int answer = 0;

    for (int i = lowLimit; i <= highLimit; i++) {
      int sum = digitSum(i);
      box.put(sum, box.getOrDefault(sum, 0) + 1);
      answer = Math.max(answer, box.get(sum));
    }

    return answer;
  }

  private int digitSum(int n) {
    int sum = 0;

    while (n > 0) {
      sum += n % 10;
      n = n / 10;
    }

    return sum;
  }

}
