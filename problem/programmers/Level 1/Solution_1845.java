/*
폰켓몬
 */

import java.util.HashSet;
import java.util.Set;

public class Solution_1845 {

  public int solution(int[] nums) {
    int answer = 0;

    Set<Integer> set = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      set.add(nums[i]);
    }

    return Math.min(set.size(), nums.length / 2);
  }
}
