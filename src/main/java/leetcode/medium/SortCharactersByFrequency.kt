package leetcode.medium

//451. Sort Characters By Frequency

fun main() {
    println(frequencySort("treesss"))
}

fun frequencySort(s: String): String {
    val result = StringBuilder()
    val map = HashMap<Char, Int>()
    for (i in s) {
        map[i] = map.getOrDefault(i, 0) + 1
    }
    for (i in map.toList().sortedBy { (_, value) -> value }.reversed().toMap().toMutableMap()) {
        result.append(i.key.toString().repeat(i.value))
    }
    return result.toString()
}