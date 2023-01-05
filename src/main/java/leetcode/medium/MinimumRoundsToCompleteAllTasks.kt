package leetcode.medium

//2244. Minimum Rounds to Complete All Tasks

fun main() {
    println(minimumRounds(intArrayOf(2, 2, 3, 3, 2, 4, 4, 4, 4, 4)))
}

fun minimumRounds(tasks: IntArray): Int {
    val counterMap = HashMap<Int, Int>()
    for (i in tasks) {
        counterMap[i] = counterMap.getOrDefault(i, 0) + 1
    }
    var result = 0
    for (i in counterMap) {
        if (i.value == 1) {
            return -1
        }
        result += if (i.value % 3 == 0) {
            i.value / 3
        } else {
            i.value / 3 + 1
        }
    }
    return result
}