package leetcode.medium.list_node

//328. Odd Even Linked List

fun main() {
    val l1 = ListNode(1)
    l1.next = ListNode(2)
    l1.next!!.next = ListNode(3)
    l1.next!!.next!!.next = ListNode(4)
    println(oddEvenList(l1))
}

fun oddEvenList(head: ListNode?): ListNode? {
    if (head == null) return null
    var odd = head
    var even = head.next
    val evenHead = even
    while (even?.next != null) {
        odd?.next = even.next
        odd = odd?.next
        even.next = odd?.next
        even = even.next
    }
    odd?.next = evenHead
    return head
}

fun oddEvenList2(head: ListNode?): ListNode? {
    var listSize = 0
    var headC = head
    var last = head
    while (headC != null) {
        last = headC
        headC = headC.next
        listSize++
    }
    if (listSize <= 2) {
        return head
    }
    headC = head
    var curr: ListNode?
    for (i in 0 until listSize / 2) {
        curr = ListNode(headC?.next!!.`val`)
        headC.next = headC.next?.next
        last?.next = curr
        last = curr

        headC = headC.next
    }
    return head
}