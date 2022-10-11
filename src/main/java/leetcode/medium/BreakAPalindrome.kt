package leetcode.medium

//1328. Break a Palindromel
fun main() {
    println(breakPalindrome("aba"))
}

fun breakPalindrome(palindrome: String): String {
    if (palindrome.length == 1) {
        return ""
    }
    val result = palindrome.toCharArray()
    for (i in 0 until palindrome.length / 2) {
        if (palindrome[i] != 'a') {
            result[i] = 'a'
            return String(result)
        }
    }
    result[palindrome.length - 1] = 'b'
    return String(result)
}