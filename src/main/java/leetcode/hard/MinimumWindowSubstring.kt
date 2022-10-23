package leetcode.hard

//76. Minimum Window Substring
fun main() {
    println(minWindow("ADOBECODEBANC", "ABC"))
}

fun minWindow(s: String, t: String): String {
    val map = hashMapOf<Char, Int>()
    for (c in t) {
        map[c] = map.getOrDefault(c, 0) + 1
    }
    var left = 0; var right = 0; var counter = t.length; var minLength = Int.MAX_VALUE; var minStart = 0
    while (right < s.length) {
        if (map.containsKey(s[right])) {
            map[s[right]] = map[s[right]]!! - 1
            if (map[s[right]]!! >= 0) {
                counter--
            }
        }
        right++
        while (counter == 0) {
            if (right - left < minLength) {
                minLength = right - left
                minStart = left
                if (minLength == t.length) {
                    return s.substring(minStart, minStart + minLength)
                }
            }
            if (map.containsKey(s[left])) {
                map[s[left]] = map[s[left]]!! + 1
                if (map[s[left]]!! > 0) {
                    counter++
                }
            }
            left++
        }
    }
    return if (minLength == Int.MAX_VALUE) return "" else return s.substring(minStart, minStart + minLength)
}