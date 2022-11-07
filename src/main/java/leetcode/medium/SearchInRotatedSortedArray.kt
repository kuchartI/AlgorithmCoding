package leetcode.medium

//33. Search in Rotated Sorted Array

fun main() {
    println(search(intArrayOf(4, 5, 6, -4, -3, -2, -1, 0, 1, 2), -4))
}

fun search(nums: IntArray, target: Int): Int {
    var l = 0
    var r = nums.size - 1
    while (l <= r) {
        val mid = l + (r - l) / 2
        val current = nums[mid]
        if (current == target) {
            return mid
        } else if (current >= nums[l]) {
            if (target >= nums[l] && target < current) r = mid - 1
            else l = mid + 1
        } else {
            if (target > current && target <= nums[r]) l = mid + 1
            else r = mid - 1
        }
    }
    return -1
}