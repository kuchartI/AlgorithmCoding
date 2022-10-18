package leetcode.easy

import kotlin.math.min

fun main() {
    println(longestCommonPrefix(arrayOf("flower", "flow", "flight")))
}
//14. Longest Common Prefix
fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) {
        return ""
    }
    var result = strs[0]
    for (s in strs) {
        val current = StringBuilder()
        var counter = 0
        while (counter < min(result.length, s.length)) {
            if (result[counter] == s[counter]) {
                current.append(s[counter])
                counter++
            } else {
                break
            }
        }
        result = current.toString()
        if (result.isEmpty()) {
            return ""
        }
    }
    return result
}