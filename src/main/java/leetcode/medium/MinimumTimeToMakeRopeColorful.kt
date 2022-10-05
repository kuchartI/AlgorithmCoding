package leetcode.medium

fun main(args: Array<String>) {
    println(minCost("abaaaccc", intArrayOf(1, 2, 3, 3, 3, 5, 1, 2)))
}

fun minCost(colors: String, neededTime: IntArray): Int {
    var result = 0
    var counter = 0
    var previousChar = '-'
    var previousIndex = 0
    for (a in colors.chars()) {
        if (previousChar == a.toChar()) {
            if (neededTime[counter] >= neededTime[previousIndex]) {
                result += neededTime[previousIndex]
                previousIndex = counter
            } else {
                result += neededTime[counter]
            }
        } else {
            previousChar = a.toChar()
            previousIndex = counter;
        }
        counter++
    }

    return result
}