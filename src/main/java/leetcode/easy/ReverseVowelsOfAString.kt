package leetcode.easy

import java.lang.StringBuilder

//345. Reverse Vowels of a String

fun main() {
    println(reverseVowels("helloA"))
}

fun reverseVowels(s: String): String {
    var left = 0
    var right = s.length - 1
    val result = StringBuilder(s)
    val vowels = hashSetOf('a', 'e', 'i', 'o', 'u')
    while (left < right) {
        if (vowels.contains(s[left].lowercaseChar())) {
            while (!vowels.contains(s[right].lowercaseChar())) {
                right--
            }
            val ch = s[right]
            result[right] = s[left]
            result[left] = ch
            right--
        }
        left++
    }
    return result.toString()
}