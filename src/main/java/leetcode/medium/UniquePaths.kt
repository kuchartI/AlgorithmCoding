package leetcode.medium

//62. Unique Paths

fun main() {
    println(uniquePaths(3, 7))
}

fun uniquePaths(m: Int, n: Int): Int {
    val dp = Array(m + 1) { IntArray(n + 1) }
    dp[1][1] = 1
    for (i in 1 until dp.size) {
        for (j in 1 until dp[0].size) {
            if (dp[i][j] == 0) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                if (i == m && j == n) {
                    return dp[i][j]
                }
            }
        }
    }
    return 1
}
