package leetcode.easy.binary_tree

//938. Range Sum of BST

fun main() {
    val root = TreeNode(10)
    root.left = TreeNode(5)
    root.left!!.left = TreeNode(3)
    root.left!!.right = TreeNode(7)
    root.right = TreeNode(15)
    root.right!!.right = TreeNode(18)
    println(rangeSumBST(root, 7, 15))
}

fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
    var result = 0
    fun bfs(node: TreeNode?) {
        if (node == null) {
            return
        }
        if (node.`val` in low..high) {
            result += node.`val`
        }
        if (node.`val` >= low) {
            bfs(node.left)
        }
        if (node.`val` <= high) {
            bfs(node.right)
        }

    }

    bfs(root)
    return result
}