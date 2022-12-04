package leetcode.medium

import kotlin.math.abs

//2256. Minimum Average Difference

fun main() {
    println(minimumAverageDifference(intArrayOf(2, 5, 3, 9, 5, 3)))
}

fun minimumAverageDifference(nums: IntArray): Int {
    var maxSum = 0L
    for (element in nums) {
        maxSum += element
    }

    var minDiff = Long.MAX_VALUE
    var result = 0
    var currSum = 0L
    for (i in nums.indices) {
        val indexDiff = nums.size - (i + 1)
        currSum += nums[i]
        val prefSum = currSum / (i + 1)
        val postSum =
            if (indexDiff == 0) 0 else (maxSum - currSum) / indexDiff
        val averageDiff = abs(postSum - prefSum)
        if (minDiff > averageDiff) {
            result = i
            minDiff = averageDiff
        }
    }

    return result
}