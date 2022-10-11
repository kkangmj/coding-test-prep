/*
 * 851. Loud and Rich (DFS)
 * Runtime: 5ms, Memory: 50.1MB
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_851_1 {

  public int[] loudAndRich(int[][] richer, int[] quiet) {
    int n = quiet.length;
    int[] answer = new int[n];
    ArrayList<Integer>[] graph = new ArrayList[n];

    Arrays.fill(answer, -1);

    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] rich : richer) {
      graph[rich[1]].add(rich[0]);
    }

    for (int i = 0; i < n; i++) {
      dfs(i, quiet, answer, graph);
    }

    return answer;
  }

  private int dfs(int indexOfPerson, int[] quiet, int[] answer, ArrayList<Integer>[] graph) {
    if (answer[indexOfPerson] == -1) {
      answer[indexOfPerson] = indexOfPerson;
      for (int child : graph[indexOfPerson]) {
        int indexOfChild = dfs(child, quiet, answer, graph);
        if (quiet[indexOfChild] < quiet[answer[indexOfPerson]]) {
          answer[indexOfPerson] = answer[indexOfChild];
        }
      }
    }

    return answer[indexOfPerson];
  }
}
