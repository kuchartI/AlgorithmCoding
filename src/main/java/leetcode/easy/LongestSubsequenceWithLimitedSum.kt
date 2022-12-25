package leetcode.easy

//2389. Longest Subsequence With Limited Sum

fun main() {
    println(answerQueries(intArrayOf(4, 5, 2, 1), intArrayOf(3, 10, 21)))
}

fun answerQueries(nums: IntArray, queries: IntArray): IntArray {
    nums.sort()
    queries.sort()
    val result = ArrayList<Int>()
    var counter = 0
    var currentSum = 0
    for (i in queries) {
        for (j in counter until nums.size) {
            if (currentSum + nums[j] > i) {
                break
            }
            counter++
            currentSum += nums[j]
        }
        result.add(counter)
    }
    return result.toIntArray()
}