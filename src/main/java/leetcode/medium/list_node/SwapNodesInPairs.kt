package leetcode.medium.list_node

//24. Swap Nodes in Pairs
fun main() {
    val l1 = ListNode(1)
    l1.next = ListNode(2)
    l1.next!!.next = ListNode(3)
    l1.next!!.next?.next = ListNode(4)
    println(swapPairs(l1))
}

fun swapPairs(head: ListNode?): ListNode? {
    var root = head
    while (root?.next != null) {
        val mid = root.next!!.`val`
        root.next?.`val` = root.`val`
        root.`val` = mid
        root = root.next!!.next
    }
    return head
}