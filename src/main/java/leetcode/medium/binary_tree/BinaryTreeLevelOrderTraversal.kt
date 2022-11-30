package leetcode.medium.binary_tree

import java.util.*

//102. Binary Tree Level Order Traversal

fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.left!!.right = TreeNode(3)
    root.right!!.left = TreeNode(15)
    root.right!!.right = TreeNode(7)
    println(levelOrder(root))
}

fun levelOrder(root: TreeNode?): List<List<Int>> {
    val result = ArrayList<ArrayList<Int>>()
    val queue = LinkedList<TreeNode?>()
    if (root == null) {
        return listOf()
    }
    queue.push(root)
    while (queue.isNotEmpty()) {
        val currQueue = LinkedList<TreeNode?>()
        val currentList = arrayListOf<Int>()
        while (queue.isNotEmpty()) {
            val current = queue.pop()!!
            currentList.add(current.`val`)
            if (current.left != null) {
                currQueue.offer(current.left)
            }
            if (current.right != null) {
                currQueue.offer(current.right)
            }
        }
        result.add(currentList)
        queue.addAll(currQueue)
    }
    return result
}