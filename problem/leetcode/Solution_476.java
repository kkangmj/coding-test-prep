/*
 * 476. Number Complement
 * Runtime: 0ms, Memory: 41.3MB
 */

public class Solution_476 {

  public static void main(String[] args) {
    Solution_476 solution_476 = new Solution_476();
    System.out.println(5 >> 3);
    System.out.println(solution_476.findComplement(5));
  }

  public int findComplement(int num) {
    int answer = 0;
    int shiftNum = num;

    for (int i = 0; i < 32; i++) {
      if (shiftNum == 0) {
        break;
      } else if ((num & (1 << i)) == 0) {
        answer += (1 << i);
      }
      shiftNum = shiftNum >> 1;
    }

    return answer;
  }
}
