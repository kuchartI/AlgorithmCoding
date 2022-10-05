package leetcode.medium.path_sum

fun main() {
    val root = TreeNode(5)
    root.left = TreeNode(4)
    root.left!!.left = TreeNode(11)
    root.left!!.left!!.left = TreeNode(7)
    root.left!!.left!!.right = TreeNode(2)
    root.right = TreeNode(8)
    root.right!!.left = TreeNode(13)
    root.right!!.right = TreeNode(4)
    root.right!!.right!!.right = TreeNode(1)
    println(hasPathSum(root, 27))
}

fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    return recursiveSearch(root, 0, targetSum)
}

private fun recursiveSearch(root: TreeNode?, promRes: Int, targetSum: Int): Boolean {
    if (root != null) {
        val promRes = promRes + root.`val`
        if (root.left == null && root.right == null && promRes == targetSum) {
            return true
        }
        if (recursiveSearch(root.left, promRes, targetSum)) {
            return true
        }
        if (recursiveSearch(root.right, promRes, targetSum)) {
            return true
        }
    }
    return false
}