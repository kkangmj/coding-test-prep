/**
 * 102. Binary Tree Level Order Traversal
 */


import java.util.ArrayList;
import java.util.List;

public class Solution_102 {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> answer = new ArrayList<>();
    ArrayList<TreeNode> array = new ArrayList<>();

    if (root != null) {
      array.add(root);
      inOrder(array, answer);
    }

    return answer;
  }

  private void inOrder(List<TreeNode> array, List<List<Integer>> answerList) {
    ArrayList<TreeNode> newArray = new ArrayList<>();
    ArrayList<Integer> answer = new ArrayList<>();

    for (TreeNode node : array) {
      if (node.left != null) {
        newArray.add(node.left);
      }
      if (node.right != null) {
        newArray.add(node.right);
      }
    }

    for (TreeNode node : array) {
      answer.add(node.val);
    }
    answerList.add(answer);

    if (!newArray.isEmpty()) {
      inOrder(newArray, answerList);
    }
  }

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
