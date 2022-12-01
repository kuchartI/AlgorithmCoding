package leetcode.easy.binary_tree

//104. Maximum Depth of Binary Tree

fun main() {
    val root = TreeNode(13)
    root.left = TreeNode(1)
    root.left!!.left = TreeNode(5)
    root.left!!.right = TreeNode(6)
    root.right = TreeNode(12)
    root.right!!.right = TreeNode(3)
    println(maxDepth(root))
}

fun maxDepth(root: TreeNode?): Int {
    var result = 0
    fun bfs(root: TreeNode?, counter: Int) {
        if (root == null) {
            if (result < counter) {
                result = counter
            }
            return
        }
        bfs(root.left, counter + 1)
        bfs(root.right, counter + 1)
    }
    bfs(root, 0)
    return result
}