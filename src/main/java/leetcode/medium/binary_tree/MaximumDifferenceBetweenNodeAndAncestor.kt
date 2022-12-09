package leetcode.medium.binary_tree

import kotlin.math.abs

//1026. Maximum Difference Between Node and Ancestor

fun main() {
    val root = TreeNode(8)
    root.left = TreeNode(3)
    root.right = TreeNode(10)
    root.left!!.left = TreeNode(1)
    root.left!!.right = TreeNode(6)
    root.right!!.right = TreeNode(14)
    root.left!!.right!!.left = TreeNode(4)
    root.left!!.right!!.left = TreeNode(7)
    root.right!!.right!!.left = TreeNode(13)
    println(maxAncestorDiff(root))
}

fun maxAncestorDiff(root: TreeNode?): Int {
    var result = 0
    fun bfs(root: TreeNode?, min: Int, max: Int) {
        if (root == null) {
            return
        }

        result = result.coerceAtLeast(abs(root.`val` - min))
        result = result.coerceAtLeast(abs(root.`val` - max))

        val currMin = min.coerceAtMost(root.`val`)
        val currMax = max.coerceAtLeast(root.`val`)

        bfs(root.left, currMin, currMax)
        bfs(root.right, currMin, currMax)
    }
    root?.`val`?.let { bfs(root, it, it) }
    return result
}