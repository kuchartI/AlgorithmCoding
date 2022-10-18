package leetcode.easy

fun main() {
    println(romanToInt("MCMXCIV"))
}

//13. Roman to Integer
fun romanToInt(s: String): Int {
    if (s.isEmpty()) {
        return 0
    }
    val romanToInt = mapOf('I' to 1, 'V' to 5, 'X' to 10,
            'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)
    var result = romanToInt[s[0]]!!
    for (i in 1 until s.length) {
        if (romanToInt[s[i]]!! > romanToInt[s[i - 1]]!!) {
            result += romanToInt[s[i]]!! - 2 * romanToInt[s[i - 1]]!!
        } else {
            result += romanToInt[s[i]]!!
        }

    }
    return result
}