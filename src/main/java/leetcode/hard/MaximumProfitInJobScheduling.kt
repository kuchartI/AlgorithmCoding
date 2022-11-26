package leetcode.hard

import java.util.*

//1235. Maximum Profit in Job Scheduling

fun main() {
    println(jobScheduling(intArrayOf(1, 2, 3, 3), intArrayOf(3, 4, 5, 6), intArrayOf(50, 10, 40, 70)))
}

fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
    val n: Int = profit.size
    val jobs = arrayOfNulls<Job>(n)
    for (i in 0 until startTime.size) {
        jobs[i] = Job(startTime[i], endTime[i], profit[i])
    }

    val dp = IntArray(jobs.size)
    Arrays.sort(jobs) { a, b -> a!!.end - b!!.end }

    dp[0] = jobs[0]!!.profit
    for (i in 1 until jobs.size) {
        dp[i] = Math.max(jobs[i]!!.profit, dp[i - 1])
        for (j in i - 1 downTo 0) {
            if (jobs[j]!!.end <= jobs[i]!!.start) {
                dp[i] = Math.max(dp[i], jobs[i]!!.profit + dp[j])
                break
            }
        }
    }
    var max = Int.MIN_VALUE
    for (`val` in dp) {
        max = Math.max(`val`, max)
    }
    return max
}

internal class Job(var start: Int, var end: Int, var profit: Int)