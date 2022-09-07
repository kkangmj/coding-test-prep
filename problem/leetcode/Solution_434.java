/**
 * 434. Number of Segments in a String
 */

import java.util.StringTokenizer;

public class Solution_434 {

  public int countSegments(String s) {
    StringTokenizer st = new StringTokenizer(s);
    return st.countTokens();
  }
}
