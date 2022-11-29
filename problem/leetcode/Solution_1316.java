/*
 * 1316. Distinct Echo Substrings
 * Runtime: 1941ms, Memory: 145.2MB
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution_1316 {

  public static void main(String[] args) {
    Solution_1316 solution_1316 = new Solution_1316();
    System.out.println(solution_1316.distinctEchoSubstrings("abcabcabc"));
  }

  public int distinctEchoSubstrings(String text) {

    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    HashSet<String> set = new HashSet<>();

    for (int i = 0; i < text.length(); i++) {
      int alphabet = text.charAt(i) - 97;

      if (!map.containsKey(alphabet)) {
        map.put(alphabet, new ArrayList<>());
      }

      map.get(alphabet).add(i);
    }

    for (Integer alphabet : map.keySet()) {
      ArrayList<Integer> list = map.get(alphabet);
      int size = list.size();

      if (size < 2) {
        continue;
      }

      for (int i = 0; i < size - 1; i++) {
        for (int j = i + 1; j < size; j++) {
          int indexA = list.get(i);
          int indexB = list.get(j);
          int lengthOfSubString = indexB - indexA;

          if (indexB + lengthOfSubString > text.length()) {
            break;
          }

          String a = text.substring(indexA, indexB);
          String b = text.substring(indexB, indexB + lengthOfSubString);

          if (a.equals(b)) {
            set.add(a);
          }
        }
      }
    }

    return set.size();
  }
}
