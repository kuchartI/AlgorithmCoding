package leetcode.easy

//69. Sqrt(x)

fun main() {
    println(mySqrt(10))
}

fun mySqrt(x: Int): Int {
    var res = 1.0
    for (i in 1..20) {
        res -= (res * res - x) / (2 * res)
    }
    return res.toInt()
}