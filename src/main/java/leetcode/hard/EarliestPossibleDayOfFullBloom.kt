package leetcode.hard

import java.util.*


//2136. Earliest Possible Day of Full Bloom

fun main() {
    println(earliestFullBloom(intArrayOf(3,11,29,4,4,26,26,12,13,10,30,19,27,2,10), intArrayOf(10,13,22,17,18,15,21,11,24,14,18,23,1,30,6)))
}

fun earliestFullBloom(plantTime: IntArray, growTime: IntArray): Int {
    val n = growTime.size
    var result = 0
    val indices = ArrayList<Int>()
    for (i in 0 until n) {
        indices.add(i)
    }
    Collections.sort(indices, Comparator.comparingInt{ i ->
        -growTime[i]
    })
    var curPlantTime = 0
    for (i in 0 until n) {
        val idx = indices[i]
        val time = curPlantTime + plantTime[idx] + growTime[idx]
        result = Math.max(result, time)
        curPlantTime += plantTime[idx]
    }
    return result
}