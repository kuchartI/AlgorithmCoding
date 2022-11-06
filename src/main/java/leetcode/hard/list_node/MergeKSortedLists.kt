package leetcode.hard.list_node

import java.util.*


//23. Merge k Sorted Lists

fun main() {
    val l1 = ListNode(1)
    l1.next = ListNode(4)
    l1.next!!.next = ListNode(5)
    val l2 = ListNode(1)
    l2.next = ListNode(3)
    l2.next!!.next = ListNode(4)
    val l3 = ListNode(2)
    l3.next = ListNode(6)
    println(mergeKLists(arrayOf(l1, l2, l3)))
}

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val queue = PriorityQueue<Int>()
    for (list in lists) {
        var root = list
        while (root != null) {
            queue.add(root.`val`)
            root = root.next
        }
    }
    if (queue.isEmpty()) {
        return null
    }
    var node = ListNode(0)
    val result = node
    while (!queue.isEmpty()) {
        node.next = ListNode(queue.remove())
        node = node.next!!
    }
    return result.next
}