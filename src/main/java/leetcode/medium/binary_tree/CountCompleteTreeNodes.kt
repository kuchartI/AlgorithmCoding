package leetcode.medium.binary_tree

//222. Count Complete Tree Nodes

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left!!.left = TreeNode(4)
    root.left!!.right = TreeNode(5)
    root.right!!.left = TreeNode(6)
    root.right!!.right = TreeNode(7)
    println(countNodes(root))
}
//O(Log(n) * Log(n))
fun countNodes(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }

    fun bfsLeft(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return bfsLeft(root.left) + 1
    }

    fun bfsRight(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return bfsRight(root.right) + 1
    }

    val h = bfsLeft(root)
    if (bfsRight(root) == h) {
        return (1 shl h) - 1
    }

    return 1 + countNodes(root.left) + countNodes(root.right)
}