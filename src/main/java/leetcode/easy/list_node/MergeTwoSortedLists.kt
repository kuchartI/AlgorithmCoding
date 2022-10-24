package leetcode.easy.list_node

//21. Merge Two Sorted Lists

fun main() {
    val l1 = ListNode(1)
    val l2 = ListNode(1)
    l1.next = ListNode(2)
    l1.next!!.next = ListNode(4)
    l2.next = ListNode(3)
    l2.next!!.next = ListNode(4)
    println(mergeTwoLists(l1, l2))
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var list1 = list1
    var list2 = list2
    if (list1 == null && list2 == null) {
        return null
    }
    var head: ListNode?
    if (list1 == null) {
        head = list2
    } else if (list2 == null) {
        head = list1
    } else if (list1.`val` > list2.`val`) {
        head = ListNode(list2.`val`)
        list2 = list2.next
    } else {
        head = ListNode(list1.`val`)
        list1 = list1.next
    }
    val result: ListNode? = head
    while (list1 != null || list2 != null) {
        while (list1 == null && list2 != null) {
            head!!.next = ListNode(list2.`val`)
            list2 = list2.next
            head = head.next
        }
        while (list2 == null && list1 != null) {
            head!!.next = ListNode(list1.`val`)
            list1 = list1.next
            head = head.next
        }
        if (list2 != null && list1!!.`val` >= list2.`val`) {
            head!!.next = ListNode(list2.`val`)
            list2 = list2.next
            head = head.next
        } else if (list1 != null && list2!!.`val` >= list1.`val`) {
            head!!.next = ListNode(list1.`val`)
            list1 = list1.next
            head = head.next
        }
    }
    return result
}