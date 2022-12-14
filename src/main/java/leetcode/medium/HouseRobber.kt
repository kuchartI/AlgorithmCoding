package leetcode.medium

//198. House Robber

fun main() {
    println(rob(intArrayOf(2, 1, 1, 2)))
}

fun rob(nums: IntArray): Int {
    var prev = 0
    var last = 0
    for (curr in nums) {
        last = (prev + curr).coerceAtLeast(last.also { prev = it })
    }
    return last
}