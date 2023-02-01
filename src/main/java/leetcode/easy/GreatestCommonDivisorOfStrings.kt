package leetcode.easy

fun main(){
    println(gcdOfStrings("A","AAAAAAA"))
}
    fun gcdOfStrings(str1: String, str2: String): String {
        fun gcd( a: Int, b: Int): Int {
            return if (b == 0) return a else gcd(b, a % b)
        }
        return if (str1 + str2 == str2 + str1) {
            str1.substring(0, gcd(str1.length,str2.length))
        } else ""
}