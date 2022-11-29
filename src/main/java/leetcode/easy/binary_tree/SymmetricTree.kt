package leetcode.easy.binary_tree

//101. Symmetric Tree

fun main() {
    val root = TreeNode(5)
    root.left = TreeNode(2)
    root.left!!.left = TreeNode(3)
    root.left!!.right = TreeNode(1)
    root.right = TreeNode(2)
    root.right!!.left = TreeNode(1)
    root.right!!.right = TreeNode(4)
    println(isSymmetric(root))
}

fun isSymmetric(root: TreeNode?): Boolean {
    val left = StringBuilder()
    val right = StringBuilder()

    fun recursiveLeft(root: TreeNode?) {
        if (root != null) {
            left.append(root.`val`)
            recursiveLeft(root.left)
            recursiveLeft(root.right)
        } else {
            left.append("(")
            return
        }
    }

    fun recursiveRight(root: TreeNode?) {
        if (root != null) {
            right.append(root.`val`)
            recursiveRight(root.right)
            recursiveRight(root.left)
        } else {
            right.append("(")
            return
        }
    }
    recursiveLeft(root!!.left)
    recursiveRight(root.right)
    return left.toString().equals(right.toString())
}