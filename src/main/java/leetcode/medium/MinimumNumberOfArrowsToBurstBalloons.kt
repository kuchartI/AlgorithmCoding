package leetcode.medium

import java.util.*

//452. Minimum Number of Arrows to Burst Balloons

fun main() {
    println(findMinArrowShots(arrayOf(intArrayOf(10, 16), intArrayOf(2, 8), intArrayOf(1, 6), intArrayOf(7, 12))))
}

fun findMinArrowShots(points: Array<IntArray>): Int {
    var result = 0

    val priorityQueue = PriorityQueue { a: IntArray, b: IntArray ->
        a[1] - b[1]
    }

    for (point in points) {
        priorityQueue.add(point)
    }

    if (priorityQueue.isEmpty()) {
        return 0
    }

    while (!priorityQueue.isEmpty()) {
        val prev = priorityQueue.poll()
        while (!priorityQueue.isEmpty() && prev[1] >= priorityQueue.peek()[0] && prev[1] <= priorityQueue.peek()[1]) {
            priorityQueue.poll()
        }
        result++
    }

    return result
}