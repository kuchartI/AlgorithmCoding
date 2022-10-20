package leetcode.medium

//12.Integer to Roman
fun main() {
    println(intToRoman(909))
}

fun intToRoman(num: Int): String {
    if (num < 1) {
        return ""
    }
    val romanMap = mapOf(1000 to "M", 900 to "CM",
            500 to "D", 400 to "CD",
            100 to "C", 90 to "XC",
            50 to "L", 40 to "XL",
            10 to "X", 9 to "IX",
            5 to "V", 4 to "IV", 1 to "I")
    var mutableNum = num
    val result = StringBuilder()
    for (i in romanMap) {
        while (i.key <= mutableNum) {
            mutableNum -= i.key
            result.append(i.value)
        }
    }
    return result.toString()
}