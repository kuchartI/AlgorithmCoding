package leetcode.medium

fun main() {
    println(maxArea(intArrayOf(1, 9, 15, 2, 5, 4, 8, 15, 7)))
}

fun maxArea(height: IntArray): Int {
    var n = height.size
    var left = 0
    var right = n - 1
    var area = 0
    while (left < right) {
        area = area.coerceAtLeast(height[left].coerceAtMost(height[right]) * (right - left))
        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }
    return area
}