package leetcode.medium

import java.util.*

//739. Daily Temperatures

fun main() {
    println(dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)).contentToString())
}

fun dailyTemperatures(temperatures: IntArray): IntArray {
    if (temperatures.size == 1) {
        return intArrayOf(0)
    }
    val result = IntArray(temperatures.size)
    val mStack = LinkedList<Int>()
    for (i in temperatures.indices) {
        while (mStack.isNotEmpty() && temperatures[mStack.peek()] < temperatures[i]) {
            result[mStack.peek()] = i - mStack.peek()
            mStack.pop()
        }
        mStack.push(i)
    }
    return result
}