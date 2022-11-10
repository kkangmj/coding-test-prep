/*
 * 1394. Find Lucky Integer in an Array
 * Runtime: 5ms, Memory: 44.2MB
 *
 * Solved with frequency count array and priority queue.
 * Time complexity: O(n)
 * Without priority queue, iterating count array or using hashmap also has same time complexity.
 */

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution_1394 {

  public int findLucky(int[] arr) {
    int answer = -1;
    int[] count = new int[501];
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    for (int i : arr) {
      count[i]++;

      if (count[i] == i) {
        pq.add(i);
      }
    }

    while (!pq.isEmpty()) {
      int value = pq.poll();
      if (value == count[value]) {
        answer = value;
        break;
      }
    }

    return answer;
  }
}
