package leetcode.medium.binary_tree

//105. Construct Binary Tree from Preorder and Inorder Traversal

fun main() {
    println(buildTree(intArrayOf(3, 9, 20, 15, 7), intArrayOf(9, 3, 15, 20, 7)))
}

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    var preorderIndex = 0
    val map = HashMap<Int, Int>()
    for (i in inorder.indices) {
        map[inorder[i]] = i
    }

    fun recursion(left: Int, right: Int): TreeNode? {
        if (left > right) {
            return null
        }

        val rootValue = preorder[preorderIndex++]
        val root = TreeNode(rootValue)

        root.left = recursion(left, map[rootValue]!! - 1)
        root.right = recursion(map[rootValue]!! + 1, right)

        return root
    }

    return recursion(0, preorder.size - 1)
}
