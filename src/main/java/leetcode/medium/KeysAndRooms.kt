package leetcode.medium

import java.util.*

//841. Keys and Rooms

fun main() {
    println(canVisitAllRooms(listOf(listOf(1, 3), listOf(3, 0, 1), listOf(2), listOf(0))))
}

fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
    val queue = LinkedList<Int>()
    val visited = BooleanArray(rooms.size)
    queue.push(0)
    visited[0] = true
    var counter = 1
    while (queue.isNotEmpty()) {
        val current = queue.pop()
        if (counter == rooms.size) {
            return true
        }
        for (i in rooms[current]) {
            if (!visited[i]) {
                counter++
                queue.push(i)
                visited[i] = true
            }
        }
    }
    return false
}