package leetcode.medium.binary_tree

//98. Validate Binary Search Tree

fun main() {
    val root = TreeNode(32)
    root.left = TreeNode(26)
    root.right = TreeNode(47)
    root.left!!.left = TreeNode(19)
    root.right!!.right = TreeNode(56)
    root.left!!.left!!.right = TreeNode(27)
    println(isValidBST(root))
}

fun isValidBST(root: TreeNode?): Boolean {
    var topValue: Int? = null
    fun inorder(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        if (!inorder(root.left)) {
            return false
        }
        if (topValue != null && root.`val` <= topValue!!) {
            return false
        }
        topValue = root.`val`
        return inorder(root.right)
    }
    return inorder(root)
}