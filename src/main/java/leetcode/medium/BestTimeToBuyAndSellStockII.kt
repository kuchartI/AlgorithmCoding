package leetcode.medium

//122. Best Time to Buy and Sell Stock II

fun main() {
    println(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
}

fun maxProfit(prices: IntArray): Int {
    val n = prices.size
    if (n < 2) {
        return 0
    }
    var profit = 0
    var sellDay = 0
    var buyDay = 0
    for (i in 1 until n) {
        if (prices[i] >= prices[i - 1]) {
            sellDay++
        } else {
            profit += prices[sellDay] - prices[buyDay]
            sellDay = i
            buyDay = i
        }
    }
    return profit + prices[sellDay] - prices[buyDay]
}