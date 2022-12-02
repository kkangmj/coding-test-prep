/*
 * 476. Number Complement
 * Runtime: 0ms, Memory: 39.2MB
 */

public class Solution_476_1 {

  public int findComplement(int num) {
    int sum = 0;
    int i = 0;

    while (sum < num) {
      sum += Math.pow(2, i);
      i++;
    }

    return sum - num;
  }
}
