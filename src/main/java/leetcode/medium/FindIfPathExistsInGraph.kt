package leetcode.medium

import java.util.*
import kotlin.collections.ArrayList


//1971. Find if Path Exists in Graph

fun main() {
    println(
        validPath(
            6,
            arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(3, 5), intArrayOf(5, 4), intArrayOf(4, 3)),
            0,
            5
        )
    )
}

fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
    val graph = HashMap<Int, ArrayList<Int>>()
    for (i in edges) {
        graph.computeIfAbsent(i[0]) { _: Int -> ArrayList() }.add(i[1])
        graph.computeIfAbsent(i[1]) { _: Int -> ArrayList() }.add(i[0])
    }
    val visited = BooleanArray(n)
    visited[source] = true
    val queue = LinkedList<Int>()
    queue.push(source)
    while (queue.isNotEmpty()) {
        val current = queue.pop()
        if (current == destination) {
            return true
        }
        for (i in graph[current]!!) {
            if (!visited[i]) {
                visited[i] = true
                queue.push(i)
            }
        }
    }
    return false
}