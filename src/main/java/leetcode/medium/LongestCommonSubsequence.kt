package leetcode.medium

//1143. Longest Common Subsequence

fun main() {
    println(longestCommonSubsequence("abcde", "ace"))
}

fun longestCommonSubsequence(text1: String, text2: String): Int {
    val dp = Array(text2.length + 1) { IntArray(text1.length + 1) }
    for (i in 1..text2.length) {
        for (j in 1..text1.length) {
            if (text2[i - 1] == text1[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
            }
        }

    }
    return dp[text2.length][text1.length]
}