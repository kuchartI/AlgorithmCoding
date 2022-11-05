package leetcode.easy.binary_tree

import java.util.LinkedList

//94. Binary Tree Inorder Traversal

fun main() {
    val root = TreeNode(5)
    root.left = TreeNode(2)
    root.left!!.left = TreeNode(5)
    root.left!!.right = TreeNode(4)
    root.right = TreeNode(11)
    root.right!!.right = TreeNode(7)
    println(inorderTraversal(root))
}

fun inorderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    val stack = LinkedList<TreeNode>()
    var root = root
    while (!stack.isEmpty() || root != null) {
        while (root != null) {
            stack.push(root)
            root = root.left
        }
        root = stack.pop()
        result.add(root.`val`)
        root = root.right
    }
    return result
}
