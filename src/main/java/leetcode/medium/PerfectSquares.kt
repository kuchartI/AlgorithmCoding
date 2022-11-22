package leetcode.medium

import kotlin.math.pow
import kotlin.math.sqrt

//279. Perfect Squares
fun main() {
    println(numSquares2(12))
}

//Lagrange's four-square theorem, stating that every natural number can be
//represented as the sum of four integer squares.
//Legendre's three-square theorem, stating that a natural number n can be represented as the sum of three
//squares of integers if and only if n is NOT of the form n=4**a * (8*b+7) for nonnegative integers a and b.
fun numSquares(n: Int): Int {
    var n = n
    if (sqrt(n.toDouble()).toInt().toDouble().pow(2.0) == n.toDouble()) {
        return 1
    }
    for (i in 1..sqrt(n.toDouble()).toInt()) {
        val num = sqrt((n - i * i).toDouble()).toInt().toDouble().pow(2.0).toInt()
        if ((n - (i * i)) == num) {
            return 2
        }
    }
    while (n % 4 == 0) {
        n /= 4
    }
    return if (n % 8 != 7) 3 else 4

}
//DP
fun numSquares2(n: Int): Int {
    val dp = IntArray(n + 1) { Int.MAX_VALUE }
    dp[0] = 0
    for (k in (1..n)) {
        for (i in (1..sqrt(k.toDouble()).toInt())) {
            dp[k] = dp[k].coerceAtMost(1 + dp[k - i * i])
        }
    }
    return dp[n]
}