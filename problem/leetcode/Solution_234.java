/**
 *  234. Palindrome Linked List
 */

import java.util.ArrayList;

public class Solution_234 {

  public boolean isPalindrome(ListNode head) {
    ArrayList<Integer> nodes = new ArrayList<>();
    ListNode node = head;

    while (node != null) {
      nodes.add(node.val);
      node = node.next;
    }

    for (int i = 0; i < nodes.size(); i++) {
      if (nodes.get(i) != nodes.get(nodes.size() - i - 1)) {
        return false;
      }
    }

    return true;
  }

  class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

}
