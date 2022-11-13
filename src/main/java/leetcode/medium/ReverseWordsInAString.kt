package leetcode.medium

//151. Reverse Words in a String

fun main() {
    println(reverseWords("a good   example w"))
}

fun reverseWords(s: String): String {
    return s.trim().split(Regex(" +")).reversed().reduce { acc, string -> "$acc $string" }
}