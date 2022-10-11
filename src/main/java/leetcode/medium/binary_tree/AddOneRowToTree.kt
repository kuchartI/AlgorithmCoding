package leetcode.medium.binary_tree

//623. Add One Row to Tree
fun main() {
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left!!.left = TreeNode(4)
    TreeNode.recursivePrint(addOneRow(root, 5, 4))
}

fun addOneRow(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {
    if (depth == 1) {
        val temp = TreeNode(`val`)
        temp.left = root
        return temp
    } else {
        recursiveSearch(root, `val`, depth, 1)
    }
    return root
}

private fun recursiveSearch(root: TreeNode?, `val`: Int, depth: Int, curDepth: Int) {
    if (root != null) {
        if (curDepth == depth - 1) {
            val insertValue = TreeNode(`val`)
            insertValue.left = root.left
            root.left = insertValue
            insertValue.right = root.right
            root.right = insertValue
            return
        }
        var curDepth = curDepth + 1
        recursiveSearch(root.left, `val`, depth, curDepth)
        recursiveSearch(root.right, `val`, depth, curDepth)
    }
}