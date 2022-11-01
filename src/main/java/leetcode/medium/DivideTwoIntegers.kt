package leetcode.medium

//29. Divide Two Integers

fun main() {
    println(divide(-7,-3))
}

fun divide(dividend: Int, divisor: Int): Int {
    if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
        return Math.ceil(dividend.toDouble() / divisor).toInt()
    } else {
        return Math.floor(dividend.toDouble() / divisor).toInt()
    }
}