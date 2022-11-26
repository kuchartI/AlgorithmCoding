package leetcode.medium

import java.util.LinkedList
import kotlin.math.pow

//907. Sum of Subarray Minimums

fun main() {

    println(sumSubarrayMins(intArrayOf(3, 1, 2, 4)))
}

fun sumSubarrayMins(arr: IntArray): Int {
    val mod = 10.0.pow(9.0) + 7
    var result = 0.0
    val monoStack = LinkedList<Int>()
    val dp = IntArray(arr.size)
    for (i in arr.indices) {
        while (monoStack.isNotEmpty() && arr[monoStack.peek()] > arr[i]) {
            monoStack.pop()
        }
        if (monoStack.size > 0) {
            val previousMin = monoStack.peek()
            dp[i] = dp[previousMin] + (i - previousMin) * arr[i]
        } else {
            dp[i] = (i + 1) * arr[i]
        }
        monoStack.push(i)
    }
    for (i in dp) {
        result += i
        result %= mod
    }
    return result.toInt()
}