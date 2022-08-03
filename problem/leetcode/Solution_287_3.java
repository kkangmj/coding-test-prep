/*
 * 287. Find the Duplicate Number (3. Negative Marking)
 * 시간복잡도: O(n)
 * Runtime: 5ms, Memory: 76MB
 */


public class Solution_287_3 {

  public int findDuplicate(int[] nums) {

    for (int i = 0; i < nums.length; i++) {
      int index = Math.abs(nums[i]);

      if (nums[index] < 0) {
        return index;
      }

      nums[index] *= -1;
    }

    return -1;
  }
}
