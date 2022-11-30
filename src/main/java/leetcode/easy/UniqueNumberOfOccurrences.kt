package leetcode.easy

//1207. Unique Number of Occurrences

fun main() {
    println(uniqueOccurrences(intArrayOf(1, 2, 2)))
}

fun uniqueOccurrences(arr: IntArray): Boolean {
    val map = hashMapOf<Int, Int>()
    for (i in arr) {
        map[i] = map.getOrDefault(i, 0) + 1
    }
    val setOfNum = HashSet(map.values)
    return setOfNum.size == map.size
}