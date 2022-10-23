package leetcode.easy

import kotlin.math.abs

fun main() {
    println(findErrorNums(intArrayOf(3, 2, 3, 4, 6, 5)).contentToString())
}
//645. Set Mismatch
fun findErrorNums(nums: IntArray): IntArray {
    var diff = 0
    var sqaureDiff = 0
    for (i in nums.indices) {
        diff += (i + 1) - nums[i]
        sqaureDiff += (i + 1) * (i + 1) - nums[i] * nums[i]
    }
    val sum = sqaureDiff / diff
    return intArrayOf((sum - diff) / 2, (sum + diff) / 2)
}
