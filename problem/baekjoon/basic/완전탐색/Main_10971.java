/**
 * 외판원 순회
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10971 {

  private static int INF = 100000001;
  private static int numOfCity;
  private static int[][] graph;
  private static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    numOfCity = Integer.parseInt(br.readLine());
    graph = new int[numOfCity][numOfCity];

    for (int i = 0; i < numOfCity; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < numOfCity; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dp = new int[numOfCity][(1 << numOfCity) - 1];
    for (int i = 0; i < numOfCity; i++) {
      Arrays.fill(dp[i], INF);
    }

    System.out.println(dfs(0, 1));
  }

  private static int dfs(int city, int visitedBitMask) {
    if (visitedBitMask == (1 << numOfCity) - 1) {
      if (graph[city][0] == 0) {
        return dp[city][0];
      }
      return graph[city][0];
    }

    if (dp[city][visitedBitMask] != INF) {
      return dp[city][visitedBitMask];
    }

    for (int i = 0; i < numOfCity; i++) {
      if (graph[city][i] != 0 && (visitedBitMask & (1 << i)) == 0) {
        dp[city][visitedBitMask] = Math.min(dp[city][visitedBitMask],
            dfs(i, visitedBitMask | (1 << i)) + graph[city][i]);
      }
    }

    return dp[city][visitedBitMask];
  }
}
