/**
 * 45. Jump Game 2
 */

public class Solution_45 {
  public int jump(int[] nums) {

    int index = 0;
    int answer = 0;

    while (index < nums.length - 1) {
      int numOfJumps = nums[index];

      if (numOfJumps == 1) {
        index++;
        answer++;
        continue;
      }

      int max = 0;
      int jumpTo = index + numOfJumps;

      if (jumpTo >= nums.length - 1) {
        answer++;
        break;
      }

      for (int i = 1; i <= numOfJumps; i++) {
        if (index + i < nums.length && nums[index + i] > numOfJumps - i
            && index + i + nums[index + i] > max) {
          max = index + i + nums[index + i];
          jumpTo = index + i;
        }
      }

      index = jumpTo;
      answer++;
    }
    return answer;
  }
}
