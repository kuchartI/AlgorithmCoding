package leetcode.easy

//374. Guess Number Higher or Lower

fun main() {
    println(guessNumber(2126753390))
}

fun guessNumber(n: Int): Int {
    var l = 0
    var r = n
    while (l <= r) {
        val mid = (l + r) ushr 1
        if (guess(mid) == 0) {
            return mid
        } else if (guess(mid) == -1) {
            r = mid - 1
        } else {
            l = mid + 1
        }

    }
    return -1
}

fun guess(num: Int): Int {
    val pick = 1702766719
    return if (num > pick) {
        -1
    } else if (num < pick) {
        1
    } else 0
}