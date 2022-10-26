package leetcode.medium

//523. Continuous Subarray Sum

fun main() {
    println(checkSubarraySum(intArrayOf(23, 3, 0, 0, 7, 4), 6))
}

fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
    val mapOfRemainder = hashMapOf(0 to -1)
    var total = 0
    for (i in 0..nums.lastIndex) {
        total += nums[i]
        val remainder = total % k
        if (!mapOfRemainder.containsKey(remainder)) {
            mapOfRemainder[remainder] = i
        } else if (i - mapOfRemainder[remainder]!! > 1) {
            return true
        }
    }
    return false
}