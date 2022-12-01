package leetcode.medium.binary_tree

import java.util.*
import kotlin.collections.ArrayList

//103. Binary Tree Zigzag Level Order Traversal

fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right!!.left = TreeNode(15)
    root.right!!.right = TreeNode(7)
    println(zigzagLevelOrder(root))
}

fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    val result = ArrayList<ArrayList<Int>>()
    var queue = LinkedList<TreeNode?>()
    if (root == null) {
        return listOf()
    }
    queue.offer(root)
    var traversal = false
    while (queue.isNotEmpty()) {
        val currentList = arrayListOf<Int>()
        val currQueue = LinkedList<TreeNode?>()
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
        if (traversal) {
            currentList.reverse()
        }
        traversal = !traversal
        result.add(currentList)
        queue = currQueue
    }
    return result
}