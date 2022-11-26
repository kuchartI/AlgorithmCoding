package leetcode.hard

import java.util.LinkedList

//84. Largest Rectangle in Histogram

fun main() {
    println(largestRectangleArea(intArrayOf(2, 1, 5, 6, 2, 2, 3, 4)))
}

fun largestRectangleArea(heights: IntArray): Int {
    var result = 0
    val monoStack = LinkedList<Int>()
    for (i in 0..heights.size) {
        var curr = 0
        if (i < heights.size) {
            curr = heights[i]
        }
        while (monoStack.isNotEmpty() && heights[monoStack.peek()] >= curr) {
            val height = heights[monoStack.pop()]
            val previous = if (monoStack.isEmpty()) -1 else monoStack.peek()
            result = result.coerceAtLeast((i - previous - 1) * height)
        }
        monoStack.push(i)
    }
    return result
}