package leetcode.easy

import java.util.*

//1047. Remove All Adjacent Duplicates In String

fun main() {
    println(removeDuplicates(""))
}

fun removeDuplicates(s: String): String {
    val list = LinkedList<String>()
    for (i in s.length - 1 downTo 0) {
        if (list.isNotEmpty() && s[i].toString() == list.first) {
            list.pop()
        } else {
            list.push(s[i].toString())
        }
    }
    return if (list.isEmpty()) "" else list.reduce { acc, string -> acc + string }
}
//fun removeDuplicates(s: String): String {
//    val str = StringBuilder(s)
//    var i = 0
//    while (i < str.length - 1) {
//        if (str[i] == str[i + 1]) {
//            str.replace(i, i + 2, "")
//            if (i > 0) i--
//            while (i >= 0 && i < str.length - 1 && str[i] == str[i + 1]) {
//                str.replace(i, i + 2, "")
//                i--
//            }
//        }
//        i++
//    }
//    return str.toString()
//}