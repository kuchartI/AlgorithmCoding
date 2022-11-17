package leetcode.medium

//53. Maximum Subarray

fun main() {
    println(maxSubArray(intArrayOf(-2, -1, -3, -4, -1, -2, -1, -5, -4)))
}

fun maxSubArray(nums: IntArray): Int {
    val n: Int = nums.size
    var max = Int.MIN_VALUE
    var sum = 0
    for (i in 0 until n) {
        sum += nums[i]
        max = sum.coerceAtLeast(max)
        if (sum < 0) sum = 0
    }
    return max
}

//because i think about dp this time but...
//fun maxSubArray(nums: IntArray): Int {
//var result = nums.maxOrNull()!!
//val n = nums.size
//var dp0 = IntArray(n)
//var dp1 = nums
//val dp2 = IntArray(n)
//for (i in 1 until n) {
//    for (j in i until n) {
//        dp2[j] = dp1[j - 1] + dp1[j] - dp0[j - 1]
//        if (result < dp2[j]) {
//            result = dp2[j]
//        }
//    }
//    dp0 = dp1.clone()
//    dp1 = dp2.clone()
//}
//return result
//}