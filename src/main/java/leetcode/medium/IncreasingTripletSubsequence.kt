package leetcode.medium

fun main() {
    println(increasingTriplet(intArrayOf(0, 5, 1, -1, 0,1, 3)))
}

fun increasingTriplet(nums: IntArray): Boolean {
    var min = Int.MAX_VALUE
    var mid = Int.MAX_VALUE
    for (max in nums) {
        if (max <= min) {
            min = max
        } else if (max <= mid) {
            mid = max
        } else {
            return true
        }
    }
    return false
}