package leetcode.easy

//263. Ugly Number

fun main() {
    println(isUgly(13))
}

fun isUgly(n: Int): Boolean {
    var simple = n
    while (n > 1) {
        simple /= if (simple % 2 == 0) 2 else if (simple % 3 == 0) 3 else if (simple % 5 == 0) 5 else return false
    }
    return simple > 0
}