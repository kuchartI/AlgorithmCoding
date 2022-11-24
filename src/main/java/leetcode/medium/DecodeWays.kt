package leetcode.medium

//91. Decode Ways

fun main() {
    println(numDecodings("1006"))
}

fun numDecodings(s: String): Int {
    if (s[0] == '0') {
        return 0
    }
    val n = s.length
    val dp = IntArray(n + 1)
    dp[0] = 1
    for (i in 1..n) {
        if (s[i - 1] != '0') {
            dp[i] = dp[i - 1]
        }
        if (i > 1) {
            val x = (s[i - 2] - '0') * 10 + (s[i - 1] - '0')
            if (x in 10..26) {
                dp[i] += dp[i - 2]
            }
        }
    }
    return dp[n]
}