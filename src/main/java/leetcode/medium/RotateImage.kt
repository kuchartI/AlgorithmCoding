package leetcode.medium

//48. Rotate Image

fun main() {
    println(
        rotate(
            arrayOf(
                intArrayOf(1,2,3),
                intArrayOf(4,5,6),
                intArrayOf(7,8,9)
            )
        )
    )
}

fun rotate(matrix: Array<IntArray>) {
    val n = matrix.size
    var counter = 0
    //Increase the counter until we reach the central cell of the square
    while (counter < n / 2) {
        //Because with each increase in counter, we seem to cut off the square by 1 layer
        for (i in counter until (n - counter) - 1) {
            //denote the current maximum in the truncated square
            val max = n - counter - 1
            //As well as indentation from the original walls
            val indent = (i - counter)
            //Simply swap all 4 sides of the current reduced square
            val rightHigh = matrix[i][max]
            matrix[i][max] = matrix[counter][i]
            val rightBot = matrix[max][max - indent]
            matrix[max][max - indent] = rightHigh
            val leftBot = matrix[max - indent][counter]
            matrix[max - indent][counter] = rightBot
            matrix[counter][i] = leftBot
        }
        counter++
    }
}