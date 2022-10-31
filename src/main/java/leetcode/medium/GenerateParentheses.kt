package leetcode.medium

import java.lang.StringBuilder

//22. Generate Parentheses

fun main() {
    println(generateParenthesis(3))
}

var list = mutableListOf<String>()
fun generateParenthesis(n: Int): List<String> {
    generateParenthesisRecursive(n, StringBuilder(), 0, 0)
    return list
}

fun generateParenthesisRecursive(n: Int, str: StringBuilder, left: Int, right: Int) {
    if (n * 2 == str.length) {
        list.add(str.toString())
        return
    }
    if (left < n) {
        generateParenthesisRecursive(n, str.append("("), left + 1, right)
        str.deleteCharAt(str.length - 1)
    }
    if (right < left) {
        generateParenthesisRecursive(n, str.append(")"), left, right + 1)
        str.deleteCharAt(str.length - 1)
    }
}