package leetcode.medium.list_node
//237. Delete Node in a Linked List
fun main() {
    val l1 = ListNode(4)
    l1.next = ListNode(5)
    l1.next!!.next = ListNode(1)
    l1.next!!.next?.next = ListNode(9)
    deleteNode(l1)
    println(l1.toString())
}

fun deleteNode(node: ListNode?) {
    node?.`val` = node?.next?.`val`!!
    node.next = node.next?.next
}