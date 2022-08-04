/*
 * 287. Find the Duplicate Number
 * 시간복잡도: O(n)
 * Runtime: 13ms, Memory: 82.1MB
 *
 * 다른 방식:
 *    1. Sort (Runtime: 51ms, Memory: 75.2MB)
 *    2. Set (Runtime: 35ms, Memory: 94.6MB)
 *    3. Negative Marking (Runtime: 5ms, Memory: 76MB) - Runtime, Memory 가장 적게 소비하는 방식
 *    4. Array as HashMap (Runtime: 6ms, Memory: 75MB)
 *    5. Sum of Set Bits
 *
 * https://leetcode.com/problems/find-the-duplicate-number/solution/
 */

public class Solution_287 {

  public int findDuplicate(int[] nums) {

    int[] check = new int[100001];

    for (int num : nums) {
      if (check[num] != 0) {
        return num;
      }
      check[num] = 1;
    }

    return -1;
  }
}
