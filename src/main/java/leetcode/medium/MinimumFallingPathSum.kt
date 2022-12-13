package leetcode.medium

//931. Minimum Falling Path Sum

fun main() {
    println(minFallingPathSum(arrayOf(intArrayOf(2, 1, 3), intArrayOf(6, 5, 4), intArrayOf(7, 8, 9))))
}

fun minFallingPathSum(matrix: Array<IntArray>): Int {
    val n = matrix.size
    val m = matrix[0].size
    val dp = Array(n) { IntArray(m) { Int.MAX_VALUE } }
    dp[0] = matrix[0]
    for (i in 0 until n - 1) {
        for (j in 0 until m) {
            if (j > 0) {
                dp[i + 1][j - 1] = Math.min(dp[i + 1][j - 1], dp[i][j] + matrix[i + 1][j - 1])
            }
            dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + matrix[i + 1][j])
            if (j < m - 1) {
                dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + matrix[i + 1][j + 1])
            }
        }
    }
    var result = Int.MAX_VALUE
    for (i in dp[n - 1]) {
        if (result > i) {
            result = i
        }
    }
    return result
}