package leetcode.medium

import java.util.*


//1657. Determine if Two Strings Are Close

fun main() {
    println(closeStrings("cabbbaa", "abbcccb"))
}

fun closeStrings(word1: String, word2: String): Boolean {
    val n = 26
    val arr1 = IntArray(n)
    val arr2 = IntArray(n)
    for (ch in word1) {
        arr1[ch - 'a']++
    }
    for (ch in word2) {
        arr2[ch - 'a']++
    }

    for (i in 0 until n) {
        if (arr1[i] == arr2[i]) {
            continue
        }
        if (arr1[i] == 0 || arr2[i] == 0) {
            return false
        }
    }
    Arrays.sort(arr1)
    Arrays.sort(arr2)
    for (i in 0 until n) {
        if (arr1[i] != arr2[i]) {
            return false
        }
    }
    return true
}