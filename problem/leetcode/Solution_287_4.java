/*
 * 287. Find the Duplicate Number (4. Array as HashMap)
 * 시간복잡도: O(n)
 * Runtime: 6ms, Memory: 75MB
 */

public class Solution_287_4 {

  public int findDuplicate(int[] nums) {

    while (nums[0] != nums[nums[0]]) {
      int index = nums[0];
      nums[0] = nums[index];
      nums[index] = index;
    }

    return nums[0];
  }
}
