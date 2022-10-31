package leetcode.medium

//28. Find the Index of the First Occurrence in a String

fun main() {
    println(strStr("aaaas", "aaas"))
}

fun strStr(haystack: String, needle: String): Int {
    if (needle.isBlank()) {
        return -1
    }
    for (i in haystack.indices) {
        var left = i
        if (haystack[i] == needle[0]) {
            for (j in needle.indices) {
                if (left < haystack.length && haystack[left] == needle[j]) {
                    left++
                    if (left - i == needle.length) {
                        return i
                    }
                } else break
            }
        }
    }
    return -1
}

//
// if (needle in haystack) {
//        return haystack.indexOf(needle)
// } else return -1