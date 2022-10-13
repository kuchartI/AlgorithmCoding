package leetcode.medium

import java.lang.StringBuilder

//984. String Without AAA or BBB
fun main() {
    println(strWithout3a3b(3, 4))
}

fun strWithout3a3b(a: Int, b: Int): String {
    var counterA = a
    var counterB = b
    val result = StringBuilder()
    while (counterA + counterB > 0) {
        if (counterA > counterB) {
            if (counterA - 2 >= 0) {
                result.append("aa")
                counterA -= 2
            } else {
                result.append("a")
                counterA--
            }
            if (counterB - 1 >= 0) {
                result.append("b")
                counterB--
            }
        } else if (counterA < counterB) {
            if (counterB - 2 >= 0) {
                result.append("bb")
                counterB -= 2
            } else {
                result.append("b")
                counterB--
            }
            if (counterA - 1 >= 0) {
                result.append("a")
                counterA--
            }
        } else {
            result.append("ab")
            counterA--
            counterB--
        }
    }
    return result.toString()
}