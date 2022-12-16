package leetcode.medium

//1. Two Sum
fun main() {
    println(twoSum(intArrayOf(2, 7, 11, 15), 9))
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val intMap: MutableMap<Int, Int> = HashMap()
    var result = IntArray(2)
    for (i in nums.indices) {
        if (intMap.containsKey(target - nums[i])) {
            result = intArrayOf(intMap[target - nums[i]]!!, i)
        }
        intMap[nums[i]] = i
    }
    return result
}