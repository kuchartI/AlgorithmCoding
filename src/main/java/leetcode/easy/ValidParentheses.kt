package leetcode.easy

import java.util.LinkedList

//20.Valid Parentheses
fun main() {
    println(isValid("()[]{}"))
}

fun isValid(s: String): Boolean {
    val map = hashMapOf('(' to ')', '{' to '}', '[' to ']')
    val list = LinkedList<Char>()
    for (i in s) {
        if (i == '(' || i == '{' || i == '[') {
            list.add(i)
        } else {
            if (list.isNotEmpty() && map[list.last!!] == i) {
                list.removeLast()
            } else return false
        }
    }
    return list.isEmpty()
}