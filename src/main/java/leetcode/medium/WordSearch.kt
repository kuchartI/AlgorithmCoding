package leetcode.medium

//79. Word Search

fun main() {
    println(
        exist(
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E')
            ), "SEE"
        )
    )

}

fun exist(board: Array<CharArray>, word: String): Boolean {
    val bool = Array(board.size) { BooleanArray(board[0].size) }
    for (i in board.indices) {
        for (j in board[0].indices) {
            if (word[0] == board[i][j] && recursive(i, j, 0, bool, board, word)) {
                return true
            }
        }
    }
    return false
}

fun recursive(i: Int, j: Int, counter: Int, bool: Array<BooleanArray>,
              board: Array<CharArray>, word: String): Boolean {
    if (counter == word.length) {
        return true
    }

    if (i < 0 || j < 0 || i >= board.size || j >= board[0].size || bool[i][j] || word[counter] != board[i][j]) {
        return false
    }

    bool[i][j] = true
    if (recursive(i + 1, j, counter + 1, bool, board, word) ||
        recursive(i - 1, j, counter + 1, bool, board, word) ||
        recursive(i, j + 1, counter + 1, bool, board, word) ||
        recursive(i, j - 1, counter + 1, bool, board, word)
    ) {
        return true
    }

    bool[i][j] = false
    return false
}