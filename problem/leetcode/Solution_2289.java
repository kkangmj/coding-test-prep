/*
 * 2289. Steps to Make Array Non-decreasing
 * Runtime: 144ms, Memory: 98.3MB
 *
 * Counter Example:
 * (1) {10, 1, 2, 3, 4, 5, 6, 1, 2, 3} => 6
 * (2) {7, 14, 4, 14, 13, 2, 6, 13} => 2
 *
 * Solution Video: https://www.youtube.com/watch?v=NQGduRE1Crk
 */

import java.util.Stack;

public class Solution_2289 {

  public static void main(String[] args) {
    Solution_2289 solution_2289 = new Solution_2289();
    int[] nums = {7, 14, 4, 14, 13, 2, 6, 13};
    System.out.println(solution_2289.totalSteps(nums));
  }

  public int totalSteps(int[] nums) {

    int lastIndex = nums.length - 1;
    int answer = 0;

    Stack<Step> stack = new Stack<>();
    stack.push(new Step(nums[lastIndex], 0));

    for (int i = lastIndex - 1; i >= 0; i--) {
      int count = 0;
      while (!stack.isEmpty() && nums[i] > stack.peek().value) {
        count = Math.max(count + 1, stack.pop().count);
      }
      answer = Math.max(answer, count);
      stack.push(new Step(nums[i], count));
    }

    return answer;
  }

  static class Step {

    private final int value;
    private final int count;

    public Step(int value, int count) {
      this.value = value;
      this.count = count;
    }
  }
}
