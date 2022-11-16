package leetcode.hard

//42. Trapping Rain Water

fun main() {
    println(trap(intArrayOf(4, 2, 0, 3, 2, 5)))
}

fun trap(height: IntArray): Int {
    var l = 0
    var r = height.size - 1
    var lMax = 0
    var rMax = 0
    var result = 0
    while (l < r) {
        if (height[l] < height[r]) {
            if (height[l] > lMax) {
                lMax = height[l]
            } else {
                result += lMax - height[l]
            }
            l++
        } else {
            if (height[r] > rMax) {
                rMax = height[r]
            } else {
                result += rMax - height[r]
            }
            r--
        }
    }
    return result
}