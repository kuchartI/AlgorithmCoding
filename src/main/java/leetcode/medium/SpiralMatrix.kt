package leetcode.medium

//54. Spiral Matrix

fun main() {
    println(spiralOrder(arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8), intArrayOf(9, 10, 11, 12))))
}

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val result = ArrayList<Int>()
    val spiralSize = matrix.size * matrix[0].size
    var right = 0
    var bot = 0
    var left = 0
    var top = 0
    while (result.size < spiralSize) {
        var rightCounter = left
        while (result.size < spiralSize && rightCounter < matrix[0].size - right) {
            result.add(matrix[top][rightCounter])
            rightCounter++
        }
        top++
        var botCounter = top
        while (result.size < spiralSize && botCounter < matrix.size - bot) {
            result.add(matrix[botCounter][matrix[0].size - right - 1])
            botCounter++
        }
        right++
        var leftCounter = matrix[0].size - right - 1
        while (result.size < spiralSize && leftCounter >= left) {
            result.add(matrix[matrix.size - bot - 1][leftCounter])
            leftCounter--
        }
        bot++
        var topCounter = matrix.size - bot - 1
        while (result.size < spiralSize && topCounter >= top) {
            result.add(matrix[topCounter][left])
            topCounter--
        }
        left++
    }

    return result
}