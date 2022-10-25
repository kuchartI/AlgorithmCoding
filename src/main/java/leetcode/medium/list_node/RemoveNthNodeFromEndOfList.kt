package leetcode.medium.list_node

//19. Remove Nth Node From End of List

fun main() {
    val l1 = ListNode(4)
    l1.next = ListNode(5)
    l1.next!!.next = ListNode(1)
    l1.next!!.next?.next = ListNode(9)
    println(removeNthFromEnd(l1, 4))
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var counter = 0
    if (head == null) {
        return null
    }
    var head = head
    var result = head
    while (head != null) {
        head = head.next
        counter++
    }
    if (counter == n) {
        result = if (counter == 1) null else result.next
        return result
    }
    val listSize = counter
    counter = 0
    head = result
    while (counter < listSize) {
        if (head!!.next!!.next == null) {
            head.next = null
            return result
        }
        if (counter + n == listSize - 1) {
            head.next = head.next!!.next
            return result
        }
        head = head.next
        counter++
    }
    return result
}