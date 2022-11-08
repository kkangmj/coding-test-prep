/*
 * 1464. Maximum Product of Two Elements in an Array
 * Runtime: 3ms, Memory: 43.3MB
 *
 * Point is how to get two biggest number in an array.
 * I've solved with sort, but Priority Queue could be also solution.
 */

import java.util.Arrays;

public class Solution_1464 {

  public int maxProduct(int[] nums) {
    Arrays.sort(nums);
    return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
  }
}
