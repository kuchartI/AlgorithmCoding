package leetcode.medium

//1020. Number of Enclaves

fun main() {
    println(
        numEnclaves(
            arrayOf(
                intArrayOf(0, 0, 0, 1, 1, 1, 0, 1, 0, 0),
                intArrayOf(1, 1, 0, 0, 0, 1, 0, 1, 1, 1),
                intArrayOf(0, 0, 0, 1, 1, 1, 0, 1, 0, 0),
                intArrayOf(0, 1, 1, 0, 0, 0, 1, 0, 1, 0),
                intArrayOf(0, 1, 1, 1, 1, 1, 0, 0, 1, 0),
                intArrayOf(0, 0, 1, 0, 1, 1, 1, 1, 0, 1),
                intArrayOf(0, 1, 1, 0, 0, 0, 1, 1, 1, 1),
                intArrayOf(0, 0, 1, 0, 0, 1, 0, 1, 0, 1),
                intArrayOf(1, 0, 1, 0, 1, 1, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 0, 1, 1, 0, 0, 0, 1)
            )
        )
    )
}

fun numEnclaves(grid: Array<IntArray>): Int {
    val n = grid.size
    val m = grid[0].size
    val visited = Array(n) { BooleanArray(m) }
    var result = 0

    fun dfs(x: Int, y: Int) {
        if (!visited[x][y]) {
            visited[x][y] = true
            if (x != 0 && grid[x - 1][y] == 1) {
                dfs(x - 1, y)
            }
            if (x != n - 1 && grid[x + 1][y] == 1) {
                dfs(x + 1, y)
            }
            if (y != 0 && grid[x][y - 1] == 1) {
                dfs(x, y - 1)
            }
            if (y != m - 1 && grid[x][y + 1] == 1) {
                dfs(x, y + 1)
            }
        }
    }

    val row = arrayOf(0, n - 1)
    val column = arrayOf(0, m - 1)
    for (i in row) {
        for (j in 0 until m) {
            if (grid[i][j] == 1 && !visited[i][j]) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    dfs(i, j)
                }
            }
        }
    }

    for (i in 0 until n) {
        for (j in column) {
            if (grid[i][j] == 1 && !visited[i][j]) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    dfs(i, j)
                }
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (grid[i][j] == 1 && !visited[i][j]) {
                result++
            }
        }
    }
    return result
}