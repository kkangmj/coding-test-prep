/*
 * 1871. Jump Game VII
 * Runtime: 44ms, Memory: 72.5MB
 *
 * Solution with using queue.
 * Time complexity in worst case: O(n^2)
 * Given minJump = 1 and maxJump = n-1, (n-1)! times calculation is needed. (Worst Case)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1871 {

  public static void main(String[] args) throws IOException {
    Solution_1871 solution_1871 = new Solution_1871();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(solution_1871.canReach(br.readLine(), 5, 99998));
  }

  public boolean canReach(String s, int minJump, int maxJump) {
    int n = s.length();

    if (s.charAt(n - 1) != '0') {
      return false;
    }

    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    int maxRange = 0;

    while (!queue.isEmpty()) {
      int p = queue.poll();

      if (p == n - 1) {
        return true;
      }

      int pl = Math.max(p + minJump, maxRange);
      int pr = Math.min(p + maxJump, n - 1);

      for (int i = pl; i <= pr; i++) {
        if (s.charAt(i) == '0') {
          queue.add(i);
        }
      }

      maxRange = pr + 1;
    }

    return false;
  }
}
