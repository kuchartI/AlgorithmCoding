package leetcode.medium.binary_tree

//1339. Maximum Product of Splitted Binary Tree

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left!!.left = TreeNode(4)
    root.left!!.right = TreeNode(5)
    root.right!!.left = TreeNode(6)
    println(maxProduct(root))
}

fun maxProduct(root: TreeNode?): Int {
    var total: Long = 0
    var result: Long = 0
    val mod = (Math.pow(10.0, 9.0) + 7)
    fun bfs(node: TreeNode?): Long {
        if (node == null) {
            return 0
        }
        val left: Long = bfs(node.left)
        val right: Long = bfs(node.right)
        result = result.coerceAtLeast((total - left - right - node.`val`) * (left + right + node.`val`))
        return left + right + node.`val`
    }
    total = bfs(root)
    bfs(root)
    return (result % mod).toInt()
}