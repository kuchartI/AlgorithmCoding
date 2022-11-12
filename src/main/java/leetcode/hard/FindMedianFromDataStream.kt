package leetcode.hard

import java.util.*

//295. Find Median from Data Stream

fun main() {
    val s = MedianFinder()
    s.addNum(1)
    s.addNum(2)
    println(s.findMedian())
    s.addNum(3)
    println(s.findMedian())
}

class MedianFinder {

    var queue = MedianPriorityQueue()
    fun addNum(num: Int) {
        queue.add(num)
    }

    fun findMedian(): Double {
        return queue.peekMedian()
    }

}

class MedianPriorityQueue {
    var left: PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())
    var right: PriorityQueue<Int> = PriorityQueue()

    fun add(value: Int) {
        if (right.size > 0 && value > right.peek()) {
            right.add(value)
        } else {
            left.add(value)
        }
        balanced()
    }

    private fun balanced() {
        if (left.size - right.size == 2) {
            right.add(left.remove())
        } else if (right.size - left.size == 2) {
            left.add(right.remove())
        }
    }

    fun peekMedian(): Double {
        return if (size() % 2 == 1) {
            peek().toDouble()
        } else if (size() > 1) {
            (peekLeft() + peekRight().toDouble()) / 2
        } else {
            return 0.0
        }
    }

    private fun peekLeft(): Int {
        return if (size() > 0) {
            left.peek()
        } else 0
    }

    private fun peekRight(): Int {
        return if (size() > 0) {
            right.peek()
        } else 0
    }

    private fun peek(): Int {
        return if (size() == 0) {
            -1
        } else if (left.size >= right.size) {
            left.peek()
        } else {
            right.peek()
        }
    }

    fun size(): Int {
        return left.size + right.size
    }
}