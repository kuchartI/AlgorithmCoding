package leetcode.medium.node

//116. Populating Next Right Pointers in Each Node

fun main() {
    val root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left!!.left = Node(4)
    root.left!!.right = Node(5)
    root.right!!.left = Node(6)
    root.right!!.right = Node(7)
    println(connect(root))
}

fun connect(root: Node?): Node? {
    var node = root

    while (node != null) {
        var currNode = node
        while (currNode != null) {
            if (currNode.left != null) {
                currNode.left?.next = currNode.right
            }
            if (currNode.right != null && currNode.next != null) {
                currNode.right?.next = currNode.next?.left
            }
            currNode = currNode.next
        }
        node = node.left

    }

    return root
}