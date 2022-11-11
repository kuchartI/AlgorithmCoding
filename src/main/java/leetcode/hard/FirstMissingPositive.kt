package leetcode.hard

//41. First Missing Positive

fun main() {
    println(firstMissingPositive(intArrayOf(2,2,2)))
}

fun firstMissingPositive(nums: IntArray): Int {
    for (i in nums.indices) {
        if (nums[i] > 0 && nums[i] <= nums.size) {
            while (nums[i] - 1 != i && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
                val next = nums[nums[i] - 1]
                nums[nums[i] - 1] = nums[i]
                nums[i] = next
            }
        } else {
            nums[i] = 0
        }
    }
    for (i in 1..nums.size) {
        if (i != nums[i - 1]) {
            return i
        }
    }
    return nums.size + 1
}