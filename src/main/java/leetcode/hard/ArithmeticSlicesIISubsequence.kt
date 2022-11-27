package leetcode.hard

//446. Arithmetic Slices II - Subsequence

fun main(){
    println(numberOfArithmeticSlices(intArrayOf(2,4,6,8,10)))
}

fun numberOfArithmeticSlices(nums: IntArray): Int {
    val n = nums.size
    var ans = 0L
    val cnt = Array(n) { HashMap<Int, Int>() }
    for (i in 0 until n) {
        cnt[i] = HashMap(i)
        for (j in 0 until i) {
            val delta = nums[i].toLong() - nums[j].toLong()
            if (delta < Int.MIN_VALUE || delta > Int.MAX_VALUE) {
                continue
            }
            val diff = delta.toInt()
            val sum = cnt[j].getOrDefault(diff, 0)
            val origin = cnt[i].getOrDefault(diff, 0)
            cnt[i][diff] = origin + sum + 1
            ans += sum.toLong()
        }
    }
    return ans.toInt()
}