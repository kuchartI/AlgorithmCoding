package leetcode.hard

//899. Orderly Queue

fun main() {
    println(orderlyQueue("baaca", 1))
}

fun orderlyQueue(s: String, k: Int): String {
    return if (k == 1) {
        var result = s
        for (i in s.indices) {
            val temp = s.substring(i) + s.substring(0, i)
            if (temp < result) {
                result = temp
            }
        }
        result
    } else {
        s.toCharArray().sortedArray().concatToString()
    }
}