/**
 * 1717. Maximum Score From Removing Substrings
 */

import java.util.Stack;

public class Solution_1717 {

  public static void main(String[] args) {
    Solution_1717 solution_1717 = new Solution_1717();
    System.out.println(solution_1717.maximumGain(
        "bbaabb",
        5, 4));
  }

  public int maximumGain(String s, int x, int y) {
    Stack<Character> stack1 = new Stack<>();
    Stack<Character> stack2 = new Stack<>();

    int result = 0;
    int maxPoint = Math.max(x, y);
    int minPoint = Math.min(x, y);
    char firstChar = x >= y ? 'a' : 'b';
    char secondChar = x >= y ? 'b' : 'a';

    for (int i = 0; i < s.length(); i++) {
      char currentChar = s.charAt(i);

      if (!stack1.isEmpty() && stack1.peek() == firstChar && currentChar == secondChar) {
        stack1.pop();
        result += maxPoint;
      } else {
        stack1.push(currentChar);
      }
    }

    while (!stack1.isEmpty()) {
      char c = stack1.pop();

      if (!stack2.isEmpty() && c == secondChar && stack2.peek() == firstChar) {
        stack2.pop();
        result += minPoint;
      } else {
        stack2.push(c);
      }
    }

    return result;
  }
}
