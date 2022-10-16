package leetcode.hard

fun main(){
    println(getLengthOfOptimalCompression("aaabcccd",2))
}

fun getLengthOfOptimalCompression(s: String, k: Int): Int {
    val n = s.length
    val dp = Array(110) { IntArray(110) }
    for (i in 0..n) for (j in 0..n) dp[i][j] = 9999
    dp[0][0] = 0
    for (i in 1..n) {
        for (j in 0..k) {
            var same = 0
            var del = 0
            for (l in i downTo 1) {
                if (s[l - 1] == s[i - 1]) same++ else del++
                if (j - del >= 0) dp[i][j] = Math.min(
                    dp[i][j],
                    dp[l - 1][j - del] + 1 + if (same >= 100) 3 else if (same >= 10) 2 else if (same >= 2) 1 else 0
                )
            }
            if (j > 0) dp[i][j] = dp[i][j].coerceAtMost(dp[i - 1][j - 1])
        }
    }
    return dp[n][k]
}