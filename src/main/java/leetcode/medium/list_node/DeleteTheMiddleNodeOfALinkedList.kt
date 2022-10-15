package leetcode.medium.list_node
//2095. Delete the Middle Node of a Linked List
fun main() {
    val l1 = ListNode(4)
    l1.next = ListNode(5)
    l1.next!!.next = ListNode(1)
    l1.next!!.next?.next = ListNode(9)
    l1.next!!.next!!.next?.next = ListNode(3)
    println(deleteMiddle(l1))
}

fun deleteMiddle(head: ListNode?): ListNode? {
    if(head?.next == null){
        return null
    }
    var counter = 0
    var currentHead = head
    while (currentHead != null) {
        counter++
        currentHead = currentHead.next
    }
    val n = counter / 2
    currentHead = head
    for (i in 0 until n -1) {
        currentHead = currentHead?.next
    }
    if (currentHead != null) {
        currentHead.next = currentHead.next?.next
    }
    return head
}