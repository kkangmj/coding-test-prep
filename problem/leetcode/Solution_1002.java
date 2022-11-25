/*
 * 1002. Find Common Characters
 * Runtime: 9ms, Memory: 43.6MB
 *
 * Use two array with index 0 to 25 which represents alphabet lowercase ascii code.
 * For each iteration, find minimum value of alphabet1 and alphabet 2.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_1002 {

  public static void main(String[] args) {
    Solution_1002 solution_1002 = new Solution_1002();
    String[] words = {"bella", "label", "roller"};
    System.out.println(solution_1002.commonChars(words));
  }

  public List<String> commonChars(String[] words) {
    ArrayList<String> answer = new ArrayList<>();
    int[] alphabet1 = new int[26];
    int[] alphabet2 = new int[26];

    for (char c : words[0].toCharArray()) {
      alphabet1[c - 97]++;
    }

    for (int i = 1; i < words.length; i++) {
      Arrays.fill(alphabet2, 0);

      for (char c : words[i].toCharArray()) {
        alphabet2[c - 97]++;
      }

      for (int j = 0; j < 26; j++) {
        alphabet1[j] = Math.min(alphabet1[j], alphabet2[j]);
      }
    }

    for (int i = 0; i < 26; i++) {
      for (int j = 0; j < alphabet1[i]; j++) {
        answer.add(String.valueOf((char) (i + 97)));
      }
    }

    return answer;
  }
}
