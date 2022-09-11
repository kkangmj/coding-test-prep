/**
 * 606. Construct String from Binary Tree
 * Runtime: 2ms, Memory: 41.9MB
 */

public class Solution_606 {

  public String tree2str(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    nodeToString(sb, root);

    return sb.toString();
  }

  private void nodeToString(StringBuilder sb, TreeNode node) {

    if (node == null) {
      return;
    }

    sb.append(node.val);

    if (node.left == null && node.right == null) {
      return;
    }

    sb.append("(");
    nodeToString(sb, node.left);
    sb.append(")");

    if (node.left != null && node.right == null) {
      return;
    }

    sb.append("(");
    nodeToString(sb, node.right);
    sb.append(")");
  }

  static class TreeNode {

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
