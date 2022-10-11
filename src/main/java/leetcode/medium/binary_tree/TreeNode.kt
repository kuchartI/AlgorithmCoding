package leetcode.medium.binary_tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    companion object {
        fun recursivePrint(root: TreeNode?) {
            if (root != null) {
                println(root.`val`)
                recursivePrint(root.left)
                recursivePrint(root.right)
            } else {
                return
            }
        }
    }
}