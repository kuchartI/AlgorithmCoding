package leetcode.easy

import kotlin.math.ceil
import kotlin.math.log10
import kotlin.math.pow

//1323. Maximum 69 Number

fun main() {
    println(maximum69Number(999))
}

fun maximum69Number(num: Int): Int {
    var temp = num
    var counter = ceil(log10(num.toDouble())).toInt()
    counter = 10.0.pow(counter.toDouble() - 1).toInt()
    while (temp > 0) {
        if (temp / counter == 9) {
            temp %= counter
            counter /= 10
        } else {
            return num / (counter * 10) * (counter * 10) + 9 * counter + num % counter
        }
    }
    return num
}