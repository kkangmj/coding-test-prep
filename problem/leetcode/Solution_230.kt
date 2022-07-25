/**
 * 230. Kth Smallest Element in a BST
 * 이진 탐색 트리의 중위 순회
 */

class Solution_230 {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val list = inOrder(root, mutableListOf())
        return list[k - 1]
    }

    fun inOrder(root: TreeNode?, nums: MutableList<Int>): MutableList<Int> {
        if (root != null) {
            inOrder(root.left, nums)
            nums.add(root.`val`)
            inOrder(root.right, nums)
        }
        return nums
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}