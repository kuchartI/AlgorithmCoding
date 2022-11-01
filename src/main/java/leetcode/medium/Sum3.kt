package leetcode.medium

//15. 3Sum
fun main() {
    println(
        threeSum(
            intArrayOf(-1, 0, 1, 2, -1, -4)
        )
    )
}

fun threeSum(nums: IntArray): List<List<Int>> {
    val repNums = ArrayList<Int>()
    val repMap: HashMap<Int, Int> = HashMap()
    for (i in nums) {
        if (repMap.containsKey(i) && repMap[i]!! < 3) {
            repMap[i]?.plus(1)?.let { repMap.put(i, it) }
        } else if (!repMap.containsKey(i)) {
            repMap[i] = 1
        }
    }
    for (i in repMap) {
        for (j in 0 until i.value) {
            repNums.add(i.key)
        }
    }
    repNums.sort()
    val result: HashSet<ArrayList<Int>> = HashSet()
    val n = repNums.size
    for (i in 0 until n) {
        val mid = repNums[i]
        var left = i + 1
        var right = n - 1
        while (left < right) {
            val current = (repNums[left] + repNums[right] + mid)
            if (current == 0) {
                result.add(arrayListOf(mid, repNums[left], repNums[right]))
            }
            if (0 > current) {
                left++
            } else {
                right--
            }
        }
    }
    return result.toList()
}
