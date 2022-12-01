package leetcode.easy

//1704. Determine if String Halves Are Alike

fun main() {
    println(halvesAreAlike("BOOK"))
}

fun halvesAreAlike(s: String): Boolean {
    val n = s.length
    if (n % 2 != 0) {
        return false
    }
    val setOfVowels = hashSetOf('a', 'e', 'i', 'o', 'u')
    var aCounter = 0
    var bCounter = 0
    for (i in 0 until n / 2) {
        if (setOfVowels.contains(s[i].lowercaseChar())) {
            aCounter++
        }
        if (setOfVowels.contains(s[n / 2 + i].lowercaseChar())) {
            bCounter++
        }
    }
    return aCounter == bCounter
}