package leetcode.easy

//217. Contains Duplicate
fun main() {
    println(containsDuplicate(intArrayOf(1, 2, 3, 1, 2, 3)))
}

fun containsDuplicate(nums: IntArray): Boolean {
    val map = hashSetOf<Int>()
    for (i in nums) {
        if (map.contains(i)) {
            return true
        } else {
            map.add(i)
        }
    }
    return false
}