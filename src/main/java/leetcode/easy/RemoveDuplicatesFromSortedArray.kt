package leetcode.easy

import java.util.*

//26. Remove Duplicates from Sorted Array

fun main() {
    println(removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)))
}

fun removeDuplicates(nums: IntArray): Int {
    var counter = 0
    var current = Int.MIN_VALUE
    for (i in 0..nums.lastIndex) {
        if (current != nums[i]) {
            current = nums[i]
            nums[counter] = current
            counter++
        }
    }
    println(Arrays.toString(nums))
    return counter
}