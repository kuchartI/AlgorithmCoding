package leetcode.medium


//78. Subsets

fun main() {
    println(subsets(intArrayOf(0, 1, 2)))
}

fun subsets(nums: IntArray): List<List<Int>> {
    val result = ArrayList<ArrayList<Int>>()
    result.add(ArrayList())
    for (i in nums) {
        for (j in 0 until result.size) {
            val set = ArrayList<Int>(result[j])
            set.add(i)
            result.add(set)
        }
    }
    return result
}