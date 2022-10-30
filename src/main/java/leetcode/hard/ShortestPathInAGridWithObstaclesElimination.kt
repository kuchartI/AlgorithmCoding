package leetcode.hard

import java.util.*


//1293. Shortest Path in a Grid with Obstacles Elimination

fun main() {
    println(
        shortestPath(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(1, 1, 0),
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 1),
                intArrayOf(0, 0, 0)
            ), 1
        )
    )
}

fun shortestPath(grid: Array<IntArray>, k: Int): Int {
    var result = 0
    val list = LinkedList<Triple<Int, Int, Int>>()
    val n = grid.size
    val m = grid[0].size
    val grayArr = Array(n) { Array(m) { BooleanArray(k + 1) } }
    val coordinates = arrayOf(Pair(-1, 0), Pair(1, 0), Pair(0, 1), Pair(0, -1))
    list.push(Triple(0, 0, k))
    while (!list.isEmpty()) {
        var size = list.size
        while (size-- > 0) {
            val curr = list.poll()
            var i = curr.first
            var j = curr.second
            if (i == n - 1 && j == m - 1)
                return result

            for (coor in coordinates) {
                i = coor.first + curr.first
                j = coor.second + curr.second

                if (i in 0 until n && j in 0 until m) {
                    if (grid[i][j] == 0 && !grayArr[i][j][curr.third]) {
                        list.add(Triple(i, j, curr.third))
                        grayArr[i][j][curr.third] = true
                    } else if (grid[i][j] == 1 && curr.third > 0 && !grayArr[i][j][curr.third - 1]) {
                        list.add(Triple(i, j, curr.third - 1))
                        grayArr[i][j][curr.third - 1] = true
                    }
                }
            }
        }
        result++
    }
    return -1
}
