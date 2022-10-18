package leetcode.medium

import java.lang.StringBuilder

fun main() {
    println(countAndSay(2))
}

//38. Count and Say
fun countAndSay(n: Int): String {
    if (n == 1) {
        return "1"
    }
    val str = countAndSay(n - 1)
    var ch = str[0]
    var counter = 0
    val resStr = StringBuilder()
    for (i in str) {
        if (ch == i) {
            counter++
        } else {
            resStr.append(counter.toString() + ch)
            ch = i
            counter = 1
        }
    }
    if (counter > 0) {
        resStr.append(counter.toString() + ch)
    }
    return resStr.toString()
}