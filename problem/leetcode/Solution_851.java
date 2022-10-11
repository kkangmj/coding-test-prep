/**
 * 851. Loud and Rich
 * Runtime: 20ms, Memory: 68MB
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution_851 {

  public static void main(String[] args) {
    Solution_851 solution_851 = new Solution_851();
    int[][] richer = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
    int[] quiet = {3, 2, 5, 4, 6, 1, 7, 0};
    System.out.println(Arrays.toString(solution_851.loudAndRich(richer, quiet)));
  }

  public int[] loudAndRich(int[][] richer, int[] quiet) {
    int n = quiet.length;
    int[] answer = new int[n];
    for (int i = 0; i < n; i++) {
      answer[i] = i;
    }

    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    for (int[] richInfo : richer) {
      int key = richInfo[1];
      int value = richInfo[0];

      if (map.containsKey(key)) {
        map.get(key).add(value);
      } else {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(value);
        map.put(key, list);
      }
    }

    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        findMin(i, answer, quiet, visited, map);
      }
    }

    return answer;
  }

  private int findMin(int index, int[] answerIndex, int[] quiet, boolean[] visited,
      HashMap<Integer, ArrayList<Integer>> map) {

    if (map.containsKey(index)) {
      ArrayList<Integer> values = map.get(index);
      for (int value : values) {
        if (visited[value]) {
          if (quiet[answerIndex[value]] < quiet[answerIndex[index]]) {
            answerIndex[index] = answerIndex[value];
          }
        } else {
          int min = findMin(value, answerIndex, quiet, visited, map);
          if (quiet[answerIndex[min]] < quiet[answerIndex[index]]) {
            answerIndex[index] = answerIndex[value];
          }
        }
      }
    }

    visited[index] = true;

    return answerIndex[index];
  }


//  private int findMin(int index, int[] min, int[] quiet, boolean[] visited,
//      HashMap<Integer, ArrayList<Integer>> map) {
//    if (map.containsKey(index)) {
//      ArrayList<Integer> values = map.get(index);
//      for (int value : values) {
//        if (visited[value] && quiet[min[value]] < quiet[min[index]]) {
//          min[index] = value;
//        } else if (!visited[value]) {
//          int minIndex = findMin(value, min, quiet, visited, map);
//
//          if (quiet[minIndex] < quiet[min[index]]) {
//            min[index] = minIndex;
//          }
//        }
//      }
//    }
//
//    visited[index] = true;
//
//    return min[index];
//  }
}
