package leetcode.medium

//1239. Maximum Length of a Concatenated String with Unique Characters
fun main() {
    println(maxLength(listOf("cha", "t", "pkmwt", "ers")))
}

fun maxLength(arr: List<String>): Int {
    var res = 0
    val cur = IntArray(26)

    fun backtrack(i: Int) {
        if (cur.any { it > 1 }) {
            return
        }

        res = maxOf(cur.filter{ it > 0 }.size, res)

        for (j in i..arr.lastIndex) {
            arr[j].forEach { cur[it - 'a']++ }
            backtrack(j+1)
            arr[j].forEach { cur[it - 'a']-- }
        }
    }

    backtrack(0)
    return res
}