package leetcode.medium

import java.util.*

//1926. Nearest Exit from Entrance in Maze

fun main() {
    println(
        nearestExit(
            arrayOf(
                charArrayOf('+', '+', '+'),
                charArrayOf('.', '.', '.'),
                charArrayOf('+', '+', '+')
            ), intArrayOf(1, 0)
        )
    )
}

fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
    val x = maze.size
    val y = maze[0].size
    val direction = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))

    maze[entrance[0]][entrance[1]] = '+'
    val queue = LinkedList<Triple<Int, Int, Int>>()
    queue.offer(Triple(entrance[0], entrance[1], 0))
    while (queue.isNotEmpty()) {
        val curr = queue.pop()
        val row = curr.first
        val col = curr.second
        val distance = curr.third

        for (i in direction) {
            val nextRow = row + i[0]
            val nextCol = col + i[1]
            if (nextCol in 0 until y && nextRow >= 0 && nextRow < x && maze[nextRow][nextCol] == '.') {
                if (nextRow == 0 || nextRow == x - 1 || nextCol == 0 || nextCol == y - 1) {
                    return distance + 1
                }
                maze[nextRow][nextCol] = '+'
                queue.offer(Triple(nextRow, nextCol, distance + 1))
            }
        }
    }
    return -1
}