package leetcode.medium

import kotlin.math.abs

//16. 3Sum Closest
fun main() {
    println(threeSumClosest(intArrayOf(-1, 2, 1, -4), 1))
}

fun threeSumClosest(nums: IntArray, target: Int): Int {
    nums.sort()
    val n = nums.size
    var closest = nums[0] + nums[1] + nums[2]
    for (i in 0 until n ) {
       val mid = nums[i]
       var left = i + 1
       var right = n - 1
        while (left < right) {
            val current = (nums[left] + nums[right] + mid)
            if (abs(target - current) < abs(target - closest)) {
                closest = current
            }
            if (target > current) {
                left++
            } else if (target < current) {
                right--
            } else {
                return current
            }
        }
    }
    return closest
}