/*
 * 287. Find the Duplicate Number (1. Sort)
 * 시간복잡도: O(nlogn) + O(n) = O(nlogn)
 * Runtime: 51ms, Memory: 75.2MB
 */

import java.util.Arrays;

public class Solution_287_1 {

  public int findDuplicate(int[] nums) {

    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) return nums[i];
    }

    return -1;
  }
}
