package leetcode.easy

//70. Climbing Stairs

fun main() {
    println(climbStairs(44))
}

fun climbStairs(n: Int): Int {
    val map = hashMapOf(1 to 1, 2 to 2)
    for (i in 3..n) {
        map[i] = map[i - 1]!! + map[i - 2]!!
    }
    return map[n]!!
}
