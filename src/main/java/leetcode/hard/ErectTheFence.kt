package leetcode.hard

import java.util.*


//587. Erect the Fence

fun main() {
    println(
        outerTrees(
            arrayOf(
                intArrayOf(0, 0), intArrayOf(50, 50), intArrayOf(0, 100), intArrayOf(100, 0), intArrayOf(100, 100),
            )
        ).forEach { println(it.contentToString()) }
    )
}


fun outerTrees(trees: Array<IntArray>): Array<IntArray> {
    Arrays.sort(
        trees
    ) { p, q -> if (q[0] - p[0] == 0) q[1] - p[1] else q[0] - p[0] }

    fun orientation(p: IntArray, q: IntArray, r: IntArray): Int {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1])
    }

    val hull = Stack<IntArray>()
    for (i in trees.indices) {
        while (hull.size >= 2 && orientation(hull[hull.size - 2], hull[hull.size - 1], trees[i]) > 0) {
            hull.pop()
        }
        hull.push(trees[i])
    }
    hull.pop()
    for (i in trees.indices.reversed()) {
        while (hull.size >= 2 && orientation(hull[hull.size - 2], hull[hull.size - 1], trees[i]) > 0) {
            hull.pop()
        }
        hull.push(trees[i])
    }
    val ret = HashSet(hull)
    return ret.toTypedArray()
}

//not working with square
//try use two yMax and two xMax
//fun outerTrees(trees: Array<IntArray>): Array<IntArray> {
//    var xMax = intArrayOf(Int.MIN_VALUE, Int.MAX_VALUE)
//    var xMin = intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE)
//    var yMax = intArrayOf(Int.MIN_VALUE, Int.MIN_VALUE)
//    var yMin = intArrayOf(Int.MIN_VALUE, Int.MAX_VALUE)
//    val result = ArrayList<IntArray>()
//    for (i in trees) {
//        if (i[0] >= xMax[0]) {
//            if (i[0] > xMax[0] || (i[0] == xMax[0] && i[1] < xMax[1]))
//                xMax = intArrayOf(i[0], i[1])
//        }
//        if (i[1] >= yMax[1]) {
//            if (i[1] > yMax[1] || (i[1] == yMax[1] && i[0] > yMax[0]))
//                yMax = intArrayOf(i[0], i[1])
//        }
//        if (i[0] <= xMin[0]) {
//            if (i[0] < xMin[0] || (i[0] == xMin[0] && i[1] < xMin[1]))
//                xMin = intArrayOf(i[0], i[1])
//        }
//        if (i[1] <= yMin[1]) {
//            if (i[1] < yMin[1] || (i[1] == yMin[1] && i[0] > yMin[0]))
//                yMin = intArrayOf(i[0], i[1])
//        }
//    }
//    fun lineEquation(x: Int, y: Int, xa: Int, xb: Int, ya: Int, yb: Int): Double {
//        if (xa == xb) {
//            return Double.NaN
//        }
//        return (x - xa).toDouble() * (yb - ya) / (xb - xa) + ya
//    }
//    for (i in trees) {
//        if ((xMax[0] == i[0] && xMax[1] == i[1]) || (xMin[0] == i[0] && xMin[1] == i[1])
//            || (yMax[0] == i[0] && yMax[1] == i[1]) || (yMin[0] == i[0] && yMin[1] == i[1])
//        ) {
//            result.add(intArrayOf(i[0], i[1]))
//            continue
//        }
//        if (lineEquation(i[0], i[1], xMax[0], yMax[0], xMax[1], yMax[1]) <= i[1]) {
//            result.add(intArrayOf(i[0], i[1]))
//        } else if (lineEquation(i[0], i[1], xMin[0], yMax[0], xMin[1], yMax[1]) <= i[1]) {
//            result.add(intArrayOf(i[0], i[1]))
//        } else if (lineEquation(i[0], i[1], xMin[0], yMin[0], xMin[1], yMin[1]) >= i[1]) {
//            result.add(intArrayOf(i[0], i[1]))
//        } else if (lineEquation(i[0], i[1], xMax[0], yMin[0], xMax[1], yMin[1]) >= i[1]) {
//            result.add(intArrayOf(i[0], i[1]))
//        }
//    }
//    val resultArr = Array(result.size) { IntArray(2) }
//    for (i in result.indices) {
//        resultArr[i] = result[i]
//    }
//    return resultArr
//}