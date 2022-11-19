package leetcode.medium

//55. Jump Game

fun main() {
    println(canJump(intArrayOf(1, 2, 3)))
}

fun canJump(nums: IntArray): Boolean {
    var result = 0
    for (i in nums.indices) {
        result =
            if (i > result) return false
            else if (result > nums.size - 1) return true
            else result.coerceAtLeast(i + nums[i])
    }
    return true
}