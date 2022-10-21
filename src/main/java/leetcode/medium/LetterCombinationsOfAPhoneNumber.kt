package leetcode.medium

//17. Letter Combinations of a Phone Number
fun main() {
    println(letterCombinations("234"))
}

fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) {
        return emptyList()
    }
    val map = linkedMapOf('2' to listOf("a", "b", "c"),
            '3' to listOf("d", "e", "f"),
            '4' to listOf("g", "h", "i"),
            '5' to listOf("j", "k", "l"),
            '6' to listOf("m", "n", "o"),
            '7' to listOf("p", "q", "r", "s"),
            '8' to listOf("t", "u", "v"),
            '9' to listOf("w", "x", "y", "z"))
    var result = mutableListOf<String>()
    val list = arrayListOf<String>()
    for (s in digits.indices) {
        if (result.isEmpty()) {
            list.addAll(map[digits[s]]!!)
        } else {
            for (s2 in map[digits[s]]!!) {
                for (i in result) {
                    list.add(i + "" + s2)
                }
            }
        }
        result = list.toMutableList()
        list.clear()
    }
    return result
}