package leetcode.easy

//242. Valid Anagram

fun main() {
    println(isAnagram("anagram", "nagaram"))
}

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) {
        return false
    }
    val map = hashMapOf<Char, Int>()
    for (i in s) {
        map[i] = map.getOrDefault(i, 0) + 1
    }
    for (i in t) {
        if (map.containsKey(i) && map[i] != 0) {
            map[i] = map[i]!! - 1
        } else return false
    }
    return true
}