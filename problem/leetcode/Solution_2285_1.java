/*
 * 2285. Maximum Total Importance of Roads
 * Runtime: 14ms, Memory: 64.8MB
 */

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution_2285_1 {

  public long maximumImportance(int n, int[][] roads) {

    int[] connected = new int[n];

    for (int[] road : roads) {
      connected[road[0]]++;
      connected[road[1]]++;
    }

    AtomicInteger importance = new AtomicInteger(0);
    Arrays.sort(connected);

    return Arrays.stream(connected).asLongStream()
        .map(count -> count * (importance.incrementAndGet()))
        .sum();
  }
}
