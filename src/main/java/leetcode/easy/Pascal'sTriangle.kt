package leetcode.easy

//118. Pascal's Triangle

fun main() {
    println(generate(5))
}

fun generate(numRows: Int): List<List<Int>> {
    val result = ArrayList<ArrayList<Int>>()
    result.add(arrayListOf(1))
    for (i in 1 until numRows) {
        val currentList = ArrayList<Int>(i)
        currentList.add(1)
        for (j in 1 until i) {
            currentList.add(result[i - 1][j - 1] + result[i - 1][j])
        }
        currentList.add(1)
        result.add(currentList)
    }
    return result
}