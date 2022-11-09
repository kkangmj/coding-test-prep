/*
 * 1871. Jump Game VII
 * Runtime: 42ms, Memory: 62.9MB
 *
 * Solution with using dequeue.
 * Time complexity in worst case: O(n)
 * In for loop, we need to check 3 things.
 * (1) Compare (i - dequeue.peekLast()). If it exceeds maxJump, it means there is no way to jump. So return false.
 * (2) Delete values from first in deque if (i - dequeue.peekFirst()) is bigger than maxJump. We don't need to care with values that satisfy this condition.
 * (3) Compare (i - dequeue.peekFirst()). If it exceeds minJump, add to dequeue because it is possible index to jump.
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_1871_1 {

  public static void main(String[] args) {
    Solution_1871_1 solution_1871_1 = new Solution_1871_1();
    System.out.println(solution_1871_1.canReach("00111010", 3, 5));
  }

  public boolean canReach(String s, int minJump, int maxJump) {
    int n = s.length();

    if (s.charAt(n - 1) != '0') {
      return false;
    }

    Deque<Integer> deque = new ArrayDeque<>();
    deque.add(0);

    for (int i = 1; i < n; i++) {
      if (s.charAt(i) == '0') {
        if (i - deque.peekLast() > maxJump) {
          return false;
        }

        while (i - deque.peekFirst() > maxJump) {
          deque.pollFirst();
        }

        if (i - deque.peekFirst() >= minJump) {
          deque.add(i);
        }
      }
    }

    return deque.getLast() == n - 1;
  }
}
