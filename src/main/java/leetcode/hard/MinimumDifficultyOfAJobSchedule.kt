package leetcode.hard

import java.lang.Integer.max
import java.lang.Integer.min
import java.util.*

fun main() {
    println(minDifficulty(intArrayOf(6, 5, 4, 3, 2, 1), 2))
}

fun minDifficulty(jobDifficulty: IntArray, d: Int): Int {
    val n = jobDifficulty.size
    val dp = Array(n) { IntArray(d + 1) }
    for (e in dp) {
        Arrays.fill(e, -1)
    }
    return if (d > n) {
        -1
    } else sol(jobDifficulty, dp, 0, n, d)
}

fun sol(nums: IntArray, dp: Array<IntArray>, ind: Int, n: Int, d: Int): Int {
    if (d == 1) {
        var max = -1
        for (i in ind until n) max = Math.max(max, nums[i])
        return max
    }
    if (dp[ind][d] != -1) {
        return dp[ind][d]
    }
    var max = -1
    var result: Int = Int.MAX_VALUE
    for (i in ind..n - d) {
        max = max(max, nums[i])
        result = min(result, max + sol(nums, dp, i + 1, n, d - 1))
    }
    return result.also { dp[ind][d] = it }
}