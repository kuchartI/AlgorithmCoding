package leetcode.medium

//2131. Longest Palindrome by Concatenating Two Letter Words

fun main() {
    println(longestPalindrome(arrayOf("ab", "ty", "yt", "lc", "cl", "aa","aa","bb")))
}

fun longestPalindrome(words: Array<String>): Int {
    val seen = hashMapOf<String, Int>()
    var result = 0
    for (s in words) {
        val reversedS = s.reversed()
        if (seen.containsKey(reversedS) && seen[reversedS]!! > 0) {
            result += 4
            seen[reversedS] = seen[reversedS]!! - 1
        } else {
            seen[s] = seen.getOrDefault(s, 0) + 1
        }
    }
    return if (seen.any { it.key[0] == it.key[1] && it.value > 0 }) result + 2 else result
}