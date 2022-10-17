package leetcode.easy

//1832. Check if the Sentence Is Pangram
fun main() {
    println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"))
}

fun checkIfPangram(sentence: String): Boolean {
    val dictionary = mutableSetOf<Char>()
    for (i in sentence) {
        if (dictionary.size != 26) {
            dictionary.add(i)
        }
        if (dictionary.size == 26) {
            return true
        }
    }
    return false
}
