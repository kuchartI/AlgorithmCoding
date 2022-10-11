package leetcode.easy.binary_tree

//653. Two Sum IV - Input is a BST
fun main() {
    val root = TreeNode(5)
    root.left = TreeNode(2)
    root.left!!.left = TreeNode(5)
    root.left!!.right = TreeNode(4)
    root.right = TreeNode(11)
    root.right!!.right = TreeNode(7)
    println(findTarget(root, 10))
}

fun findTarget(root: TreeNode?, k: Int): Boolean {
    val table: HashMap<Int, Int> = HashMap()
    return recursiveSearch(root, table, k)
}

private fun recursiveSearch(root: TreeNode?, table: HashMap<Int, Int>, k: Int): Boolean {
    if (root != null) {
        if (table.containsKey(root.`val`)) {
            table[root.`val`]?.plus(1)?.let { table.put(root.`val`, it) }
        } else {
            table[root.`val`] = 1
        }
        val tempVal = k - root.`val`
        if (table.containsKey(tempVal)) {
            if ((tempVal == root.`val` && table.get(root.`val`)!! > 1) || tempVal != root.`val`) {
                return true
            }
        }
        if (recursiveSearch(root.left, table, k)) {
            return true
        }
        if (recursiveSearch(root.right, table, k)) {
            return true
        }
    }
    return false
}