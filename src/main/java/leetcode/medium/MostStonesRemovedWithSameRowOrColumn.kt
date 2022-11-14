package leetcode.medium

//947. Most Stones Removed with Same Row or Column

fun main() {
    println(
        removeStones(
            arrayOf(
                intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(1, 1),
                intArrayOf(2, 1), intArrayOf(2, 2), intArrayOf(3, 2), intArrayOf(3, 3),
                intArrayOf(3, 4), intArrayOf(4, 3), intArrayOf(4, 4), intArrayOf(7, 7)
            )
        )
    )
}

fun removeStones(stones: Array<IntArray>): Int {
    var result = stones.size
    val graphX = HashMap<Int, ArrayList<Int>>()
    val graphY = HashMap<Int, ArrayList<Int>>()
    val visited = HashSet<Pair<Int, Int>>()
    for (coordinate in stones) {
        graphX.getOrPut(coordinate[0]) { arrayListOf() }.add(coordinate[1])
        graphY.getOrPut(coordinate[1]) { arrayListOf() }.add(coordinate[0])
    }

    fun dfs(x: Int, y: Int) {
        if (!visited.contains(Pair(x, y))) {
            visited.add(Pair(x, y))
            for (yy in graphX[x]!!) {
                dfs(x, yy)
            }
            for (xx in graphY[y]!!) {
                dfs(xx, y)
            }
        }
    }

    for (coordinate in stones) {
        if (!visited.contains(Pair(coordinate[0], coordinate[1]))) {
            dfs(coordinate[0], coordinate[1])
            result--
        }
    }
    return result
}