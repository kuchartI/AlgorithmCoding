package leetcode.easy

import java.lang.StringBuilder

//1544. Make The String Great

fun main() {
    println(makeGood("abBabBabBAcCAcCAcC"))
}

fun makeGood(s: String): String {
    val str = StringBuilder(s)
    var i = 0
    while (i < str.length - 1) {
        if (Math.abs('A' - 'a') == Math.abs(str[i] - str[i + 1])) {
            str.replace(i, i + 2, "")
            if (i > 0) i--
            while (i >= 0 && i < str.length - 1 && Math.abs('A' - 'a') == Math.abs(str[i] - str[i + 1])) {
                str.replace(i, i + 2, "")
                i--
            }
        }
        i++
    }
    return str.toString()
}
