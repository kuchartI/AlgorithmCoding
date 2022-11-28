package leetcode.medium

import java.util.TreeSet

//2225. Find Players With Zero or One Losses

fun main() {
    println(
        findWinners(
            arrayOf(
                intArrayOf(1, 3), intArrayOf(2, 3), intArrayOf(3, 6), intArrayOf(5, 6), intArrayOf(5, 7),
                intArrayOf(4, 5), intArrayOf(4, 8), intArrayOf(4, 9), intArrayOf(10, 4), intArrayOf(10, 9)
            )
        )
    )
    println(
        findWinners2(
            arrayOf(
                intArrayOf(1, 3), intArrayOf(2, 3), intArrayOf(3, 6), intArrayOf(5, 6), intArrayOf(5, 7),
                intArrayOf(4, 5), intArrayOf(4, 8), intArrayOf(4, 9), intArrayOf(10, 4), intArrayOf(10, 9)
            )
        )
    )
}

//O(n + k), k - max value
fun findWinners(matches: Array<IntArray>): List<List<Int>> {
    val list1 = TreeSet<Int>()
    val list2 = TreeSet<Int>()
    val k = 100001
    val arr = IntArray(k)
    for (i in matches) {
        if (arr[i[0]] == 0) {
            arr[i[0]] = 1
        }
        if (arr[i[1]] == 0) {
            arr[i[1]] = 2
        } else {
            arr[i[1]] += 1
        }
    }
    for (i in arr.indices) {
        if (arr[i] == 1) {
            list1.add(i)
        } else if (arr[i] == 2) {
            list2.add(i)
        }
    }

    return listOf(list1.toList(), list2.toList())
}

//O(n*log(n))
fun findWinners2(matches: Array<IntArray>): List<List<Int>> {
    val list1 = TreeSet<Int>()
    val list2 = TreeSet<Int>()
    val map = HashMap<Int, Int>()
    for (i in matches) {
        map[i[1]] = map.getOrDefault(i[1], 0) + 1
        map[i[0]] = map.getOrDefault(i[0], 0)
    }
    for (i in map.entries) {
        if (i.value == 0) {
            list1.add(i.key)
        } else if (i.value == 1) {
            list2.add(i.key)
        }
    }
    return listOf(list1.toList(), list2.toList())
}