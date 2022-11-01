package leetcode.medium

//1706. Where Will the Ball Fall

fun main() {
    println(
        findBall(
            arrayOf(
                intArrayOf(1, 1, 1, -1, -1),
                intArrayOf(1, 1, 1, -1, -1),
                intArrayOf(-1, -1, -1, 1, 1),
                intArrayOf(1, 1, 1, 1, -1),
                intArrayOf(-1, -1, -1, -1, -1)
            )
        ).contentToString()
    )
}

fun findBall(grid: Array<IntArray>): IntArray {
    val dp = IntArray(grid[0].size)
    val n = grid.size
    val m = grid[0].size
    for (i in 0 until m) {
        var currentColumn = i
        for (j in 0 until n) {
            val nextColumn = currentColumn + grid[j][currentColumn]
            if (nextColumn < 0 || nextColumn > m - 1 || grid[j][currentColumn] != grid[j][nextColumn]) {
                dp[i] = -1
                break
            }
            dp[i] = nextColumn
            currentColumn = nextColumn
        }
    }

    return dp
}