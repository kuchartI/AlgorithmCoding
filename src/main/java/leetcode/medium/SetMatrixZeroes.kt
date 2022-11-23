package leetcode.medium

//73. Set Matrix Zeroes

fun main() {
    println(setZeroes(arrayOf(intArrayOf(0, 1, 2, 0), intArrayOf(3, 4, 5, 2), intArrayOf(1, 3, 1, 5))))
}

fun setZeroes(matrix: Array<IntArray>): Unit {
    val zeroIndexes = ArrayList<Pair<Int, Int>>()
    for (i in matrix.indices) {
        for (j in matrix[0].indices) {
            if (matrix[i][j] == 0) {
                zeroIndexes.add(Pair(i, j))
            }
        }
    }
    var counter = matrix.size * matrix[0].size
    for (c in zeroIndexes) {
        var rowCounter = matrix.size - 1
        var colCounter = matrix[0].size - 1
        while (rowCounter >= 0 || colCounter >= 0) {
            if (rowCounter >= 0) {
                if (matrix[rowCounter][c.second] != 0) {
                    counter--
                }
                matrix[rowCounter][c.second] = 0
                rowCounter--
            }
            if (colCounter >= 0) {
                if (matrix[c.first][colCounter] != 0) {
                    counter--
                }
                matrix[c.first][colCounter] = 0
                colCounter--
            }
            if (counter <= 0) {
                break
            }
        }
    }
}