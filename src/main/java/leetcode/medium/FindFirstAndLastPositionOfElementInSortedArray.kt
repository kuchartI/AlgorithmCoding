package leetcode.medium

//34. Find First and Last Position of Element in Sorted Array

fun main() {
    println(searchRange(intArrayOf(0, 0, 0, 2, 3), 2).contentToString())
}

//dificult but O(log(n))
fun searchRange(nums: IntArray, target: Int): IntArray {
    val result = intArrayOf(-1, -1)
    var l = 0
    var r = nums.size - 1
    while (l <= r) {
        val mid = (l + r) / 2
        if (nums[mid] == target) {
            l = 0
            var indexLeft = mid
            var indexRight = mid
            r = nums.size - 1
            while (l <= indexLeft) {
                val midLeft = (l + indexLeft) / 2
                if (nums[midLeft] == target && (midLeft == 0 || nums[midLeft - 1] < target)) {
                    result[0] = midLeft
                    break
                } else if (nums[midLeft] == target && nums[midLeft - 1] == target) {
                    indexLeft = midLeft - 1
                } else {
                    l = midLeft + 1
                }
            }
            while (indexRight <= r) {
                val midRight = (r + indexRight) / 2
                if (nums[midRight] == target && (midRight == nums.size - 1 || nums[midRight + 1] > target)) {
                    result[1] = midRight
                    break
                } else if (nums[midRight] == target && nums[midRight + 1] == target) {
                    indexRight = midRight + 1
                } else {
                    r = midRight - 1
                }
            }
            return result
        } else if (nums[mid] < target) {
            l = mid + 1
        } else {
            r = mid - 1
        }
    }
    return result
}
