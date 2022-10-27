/*
피로도 - 완전탐색(순열)
 */

public class Solution_87946 {

  public static void main(String[] args) {
    Solution_87946 solution_87946 = new Solution_87946();
    int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
    System.out.println(solution_87946.solution(80, dungeons));
  }

  private static int maxDungeons = 0;

  public int solution(int k, int[][] dungeons) {
    int n = dungeons.length;

    boolean[] visited = new boolean[n];

    permutation(0, n, k, dungeons, visited);

    return maxDungeons;
  }

  private void permutation(int depth, int n, int k, int[][] dungeons, boolean[] visited) {
    if (depth == n) {
      maxDungeons = depth;
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        if (dungeons[i][0] <= k) {
          visited[i] = true;
          permutation(depth + 1, n, k - dungeons[i][1], dungeons, visited);
          visited[i] = false;
        } else {
          maxDungeons = Math.max(maxDungeons, depth);
        }
      }
    }
  }
}
