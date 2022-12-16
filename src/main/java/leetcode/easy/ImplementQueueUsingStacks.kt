package leetcode.easy

import java.util.*

//232. Implement Queue using Stacks

fun main() {
    val myQueue = MyQueue()
    println(myQueue.push(1))
    println(myQueue.push(2))
    println(myQueue.peek())
    println(myQueue.pop())
    println(myQueue.empty())
}

class MyQueue {

    val queue = LinkedList<Int>()

    fun push(x: Int) {
        queue.offer(x)
        return
    }

    fun pop(): Int {
        return queue.pop()
    }

    fun peek(): Int {
        return queue.peek()
    }

    fun empty(): Boolean {
        return queue.isEmpty()
    }

}