package leetcode.easy

//66. Plus One

fun main() {
    println(plusOne(intArrayOf(9, 9, 9, 2)).contentToString())
}

fun plusOne(digits: IntArray): IntArray {
    var plus = 1
    for (i in digits.lastIndex downTo 0) {
        if (digits[i] + plus > 9) {
            digits[i] = 0
            plus = 1
        } else {
            digits[i] += plus
            plus = 0
        }
    }
    return if (digits[0] == 0) intArrayOf(1) + digits else digits
}