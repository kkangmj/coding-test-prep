/*
 * 2012. Sum of Beauty in the Array
 * Runtime: 19ms, Memory: 96.1MB
 *
 * (1) Calculate min value from right side in each index and put it in array.
 * (2) Check if it satisfies condition with max value and min array.
 * Time complexity: O(n)
 */

public class Solution_2012 {

  public static void main(String[] args) {
    Solution_2012 solution_2012 = new Solution_2012();
    int[] nums = {1, 2, 3};
    System.out.println(solution_2012.sumOfBeauties(nums));
  }

  public int sumOfBeauties(int[] nums) {

    int N = nums.length;
    int sum = 0;
    int max = nums[0];
    int[] min = new int[N];

    min[N - 1] = nums[N - 1];

    for (int i = N - 2; i >= 0; i--) {
      min[i] = Math.min(min[i + 1], nums[i]);
    }

    for (int i = 1; i < N - 1; i++) {
      if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
        sum += (nums[i] < min[i + 1] && nums[i] > max) ? 2 : 1;
      }

      max = Math.max(max, nums[i]);
    }

    return sum;
  }
}
