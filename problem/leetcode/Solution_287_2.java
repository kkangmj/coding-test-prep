/*
 * 287. Find the Duplicate Number (2. Set)
 * 시간복잡도: O(n)
 * Runtime: 35ms, Memory: 94.6MB
 */

import java.util.HashSet;

public class Solution_287_2 {

  public int findDuplicate(int[] nums) {

    HashSet<Integer> set = new HashSet<>();

    for (int num : nums) {
      if (set.contains(num)) {
        return num;
      }
      set.add(num);
    }

    return -1;
  }
}
