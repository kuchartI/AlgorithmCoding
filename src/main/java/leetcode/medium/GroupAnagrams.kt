package leetcode.medium

//49. Group Anagrams

fun main() {
    println(groupAnagrams(arrayOf("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxzy")))
    println(groupAnagrams2(arrayOf("aaaaaaaaaaaaaaaad", "daaaaaaaaaaaaaaaa")))

}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = hashMapOf<String, ArrayList<String>>()
    for (s in strs) {
        val chars = IntArray(26)
        val resStr = StringBuilder()
        for (ch in s) {
            chars[ch - 'a']++
        }
        for (i in 0 until 26) {
            if (chars[i] > 0)
                resStr.append('a' + i.toString().repeat(chars[i]))
        }
        if (map.containsKey(resStr.toString())) {
            map[resStr.toString()]!!.add(s)
        } else {
            map[resStr.toString()] = arrayListOf(s)
        }
    }
    return ArrayList(map.values)
}

fun groupAnagrams2(strs: Array<String>): List<List<String>> {
    val map = HashMap<String, ArrayList<String>>()
    for (s in strs) {
        val chars = s.toCharArray()
        chars.sort()
        val sortedString = String(chars)
        if (map.containsKey(sortedString)) {
            map[sortedString]!!.add(s)
        } else {
            map[sortedString] = arrayListOf(s)
        }
    }
    return ArrayList(map.values)
}