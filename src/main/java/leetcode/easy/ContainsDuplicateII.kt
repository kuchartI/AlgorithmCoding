package leetcode.easy

import kotlin.math.abs

//219. Contains Duplicate II

fun main() {
    println(containsNearbyDuplicate(intArrayOf(1,2,3,1,2,3), 2))
}

fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val map = hashMapOf<Int, Int>()
    for (i in nums.indices) {
        if (map.contains(nums[i])) {
            if (abs(map[nums[i]]!! - i) <= k) {
                return true
            } else {
                map[nums[i]] = i
            }
        } else {
            map[nums[i]] = i
        }
    }
    return false
}