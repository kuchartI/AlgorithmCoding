package leetcode.easy.list_node

//876. Middle of the Linked List

fun main(){
    val l1 = ListNode(1)
    l1.next = ListNode(2)
    l1.next!!.next = ListNode(4)
    println(middleNode(l1))
}
fun middleNode(head: ListNode?): ListNode? {
    var root = head
    var x2Root = head
    while(x2Root?.next != null && root != null){
        root = root.next
        x2Root = x2Root.next?.next
    }
    return root
}