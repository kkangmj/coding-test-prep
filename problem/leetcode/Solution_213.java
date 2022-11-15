/*
 * 213. House Robber II
 * Runtime: 0ms, Memory: 42.2MB
 *
 * First approach was exhaustive search(완전탐색) by dfs. But time limit exceeds in test case when nums.length is more than 50.
 * So, I've used memorization to solve this problem.
 * Time complexity: O(n)
 */

public class Solution_213 {

  public static void main(String[] args) {
    Solution_213 solution_213 = new Solution_213();
    int[] nums = {2, 3};
    System.out.println(solution_213.rob(nums));
  }

  private static int N;

  public int rob(int[] nums) {

    N = nums.length;

    if (N == 1) {
      return nums[0];
    }

    return Math.max(robHouse(0, N - 1, nums), robHouse(1, N, nums));
  }

  private int robHouse(int start, int end, int[] nums) {
    int[] dp = new int[N];

    if (start == 0) {
      dp[0] = nums[0];
      dp[1] = dp[0];
    } else {
      dp[0] = 0;
      dp[1] = nums[1];
    }

    for (int i = 2; i < end; i++) {
      dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
    }

    return dp[end - 1];
  }
}
