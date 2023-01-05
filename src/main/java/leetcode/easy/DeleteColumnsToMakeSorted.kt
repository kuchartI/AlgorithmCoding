package leetcode.easy

//944. Delete Columns to Make Sorted
fun main() {
    println(minDeletionSize(arrayOf("cba", "daf", "ghi")))
}

fun minDeletionSize(strs: Array<String>): Int {
    var counter = 0
    var a = 0
    for (j in 0 until strs[0].length) {
        for (i in strs.indices) {
            if (a > strs[i][j] - 'a') {
                counter++
                break
            }
            a = strs[i][j] - 'a'
        }
        a = 0
    }
    return counter
}
