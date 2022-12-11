package leetcode.hard.binary_tree

//124. Binary Tree Maximum Path Sum

fun main() {
    val root = TreeNode(-8)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right!!.left = TreeNode(15)
    root.right!!.right = TreeNode(7)
    println(maxPathSum(root))
}

fun maxPathSum(root: TreeNode?): Int {
    var result = Int.MIN_VALUE
    fun bfs(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val left = bfs(root.left).coerceAtLeast(0)

        val right = bfs(root.right).coerceAtLeast(0)

        result = result.coerceAtLeast(left + right + root.`val`)

        return (left + root.`val`).coerceAtLeast(right + root.`val`)
    }
    bfs(root)
    return result
}