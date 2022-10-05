package leetcode.medium

fun main() {
    for (pair in merge(arrayOf(intArrayOf(2, 4), intArrayOf(0, 2), intArrayOf(3, 5), intArrayOf(15, 18)))) {
        println(pair.contentToString())
    }
}

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    intervals.sortWith(compareBy({ it[0] }, { it[1] }))
    var result: Array<IntArray> = emptyArray()
    var previousPair = intArrayOf(0, 0)
    var counter = -1
    for (pair in intervals) {
        if (counter != -1 && previousPair[1] >= pair[0]) {
            val prom = intArrayOf(previousPair[0].coerceAtMost(pair[0]), pair[1].coerceAtLeast(previousPair[1]))
            if (result.isEmpty()) {
                result += prom
            } else {
                result[counter] =
                    prom
            }
            previousPair = prom
        } else {
            result += pair;
            previousPair = pair;
            counter++
        }
    }
    return result
}