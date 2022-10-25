package leetcode.easy

//1662. Check If Two String Arrays are Equivalent

fun main() {
    println(arrayStringsAreEqual(arrayOf("abc", "d", "defg"), arrayOf("abcddefg")))
}

fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
    return word1.joinToString(separator = "") == word2.joinToString(separator = "")
}