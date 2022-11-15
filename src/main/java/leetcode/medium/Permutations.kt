package leetcode.medium

//46. Permutations

fun main() {
    println(permute(intArrayOf(1, 2, 3)))
}

fun permute(nums: IntArray): List<List<Int>> {
    val result = ArrayList<ArrayList<Int>>()
    val visited = BooleanArray(nums.size)

    fun bfs(value: ArrayList<Int>) {
        if (value.size == nums.size) {
            result.add(ArrayList(value))
        } else {
            for (i in nums.indices) {
                if (!visited[i]) {
                    value.add(nums[i])
                    visited[i] = true
                    bfs(value)
                    value.removeLast()
                    visited[i] = false
                }
            }
        }
    }
    bfs(ArrayList())

    return result
}