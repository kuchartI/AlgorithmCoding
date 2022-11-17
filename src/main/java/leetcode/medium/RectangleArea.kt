package leetcode.medium

//223. Rectangle Area

fun main() {
    println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2))
}

fun computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int {
    return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) -
            if (ax2 < bx1 || ax1 > bx2 || ay1 > by2 || by1 > ay2) 0
            else (ax2.coerceAtMost(bx2) - ax1.coerceAtLeast(bx1)) * (ay2.coerceAtMost(by2) - ay1.coerceAtLeast(by1))
}