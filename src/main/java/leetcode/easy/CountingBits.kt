package leetcode.easy

import java.util.*

//338. Counting Bits
fun main() {
    println(Arrays.toString(countBits(32)))
}

//0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4,1,2,2,3,2,3,3,4,2,3,3,4,3,4,4,5,1
//0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4,1,2,2,3,2,3,3,4,2,3,3,4,3,4,4,5,1

fun countBits(n: Int): IntArray {
    val result = IntArray(n + 1)
    result[0] = 0
    if (n == 0) return result
    result[1] = 1
    if (n == 1) return result
    var leftPart = 1
    var rigthPart = 2
    var i = 2
    while (i <= n) {
        while (i <= n && i != leftPart + rigthPart) {
            result[i] = result[i - leftPart]
            i++
        }
        while (i <= n && i != rigthPart * 2) {
            result[i] = result[i - rigthPart] + 1
            i++
        }
        leftPart *= 2
        rigthPart *= 2
    }
    return result
}