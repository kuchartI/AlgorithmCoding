package leetcode.medium

import java.util.*
import kotlin.collections.ArrayList

class TimeMap() {
    private val timeMap: HashMap<String, ArrayList<Pair<Int, String>>> = HashMap<String, ArrayList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        if (timeMap.containsKey(key)) {
            timeMap[key]?.add(Pair(timestamp, value))
        } else {
            val temp = ArrayList<Pair<Int, String>>()
            temp.add(Pair(timestamp, value))
            timeMap[key] = temp
        }
    }

    fun get(key: String, timestamp: Int): String? {
        if (!timeMap.containsKey(key)) {
            return ""
        }
        var left = 0
        var right = timeMap[key]?.size
        while (left < right!!) {
            val middle = (right + left) / 2
            if (timeMap[key]?.get(middle)?.first!! <= timestamp) {
                left = middle + 1
            } else {
                right = middle
            }
        }
        return if (right == 0) "" else timeMap[key]?.get(right - 1)?.second
    }

}