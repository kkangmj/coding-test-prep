/*
 * 2285. Maximum Total Importance of Roads
 * Runtime: 77ms, Memory: 121.7MB
 */

import java.util.PriorityQueue;

public class Solution_2285 {

  public static void main(String[] args) {
    Solution_2285 solution_2285 = new Solution_2285();
    int[][] roads = {{0, 3}, {2, 4}, {1, 3}};
    System.out.println(solution_2285.maximumImportance(5, roads));
  }

  public long maximumImportance(int n, int[][] roads) {

    int[] connected = new int[n];

    for (int[] road : roads) {
      int x = road[0];
      int y = road[1];

      connected[x]++;
      connected[y]++;
    }

    PriorityQueue<Long> pq = new PriorityQueue<>();

    for (long count : connected) {
      pq.add(count);
    }

    long answer = 0;
    long importance = 1;

    while (!pq.isEmpty()) {
      answer += (pq.poll() * importance);
      importance++;
    }

    return answer;
  }
}
